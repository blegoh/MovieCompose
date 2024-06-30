package com.example.moviecompose.ui.template

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviecompose.R
import com.example.moviecompose.extension.toImageUrl
import com.example.moviecompose.repositories.data.SeasonDetail
import com.example.moviecompose.repositories.data.SeriesDetail
import com.example.moviecompose.theme.MovieComposeTheme
import com.example.moviecompose.ui.component.EpisodeCard
import com.example.moviecompose.ui.component.Header

@Composable
fun DetailSeries(
    seriesDetail: SeriesDetail,
    seasonDetail: SeasonDetail?,
    onSeasonClick: (season: Int) -> Unit,
    onBack: () -> Unit
) {
    LazyColumn {
        item {
            Header(
                cover = seriesDetail.backdropPath?.toImageUrl() ?: "",
                title = seriesDetail.name ?: "",
                date = seriesDetail.firstAirDate?.split("-")?.firstOrNull() ?: "",
                overview = seriesDetail.overview ?: "",
            )
            seriesDetail.seasons?.let { seasons ->
                var selected by remember {
                    mutableIntStateOf(seasons.first().id)
                }
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(
                        dimensionResource(id = R.dimen.dimen_4dp)
                    ),
                    contentPadding = PaddingValues(
                        end = 16.dp,
                        start = 16.dp
                    )
                ) {
                    items(seasons) { season ->
                        FilterChip(
                            onClick = {
                                selected = season.id
                                onSeasonClick(season.seasonNumber)
                            },
                            label = {
                                Text(
                                    text = season.name ?: "",
                                    fontSize = 8.sp,
                                    textAlign = TextAlign.Center,
                                )
                            },
                            selected = selected == season.id,
                        )
                    }
                }
            }
        }

        // episode
        seasonDetail?.episodes?.let {
            items(it) { episode ->
                EpisodeCard(
                    cover = episode.stillPath ?: "",
                    episode = episode.episodeNumber ?: 0,
                    overview = episode.overview ?: ""
                ) {

                }
            }
        }
    }

    Image(
        painter = painterResource(id = R.drawable.back),
        contentDescription = "",
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                onBack()
            }
    )
}

@Preview
@Composable
fun PreviewSeriesDetail() {
    MovieComposeTheme(darkTheme = false) {
        DetailSeries(SeriesDetail(), SeasonDetail(id = 1), {}) {}
    }
}