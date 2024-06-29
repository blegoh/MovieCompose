package com.example.moviecompose.view.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviecompose.R
import com.example.moviecompose.repositories.data.SeriesDetail
import com.example.moviecompose.theme.MovieComposeTheme

@Composable
fun DetailSeries(
    seriesDetail: SeriesDetail,
    onSeasonClick: (season: Int) -> Unit,
    onBack: () -> Unit
) {
    Column {
        Header(
            cover = "https://image.tmdb.org/t/p/w500/${seriesDetail.backdropPath}",
            title = seriesDetail.name ?: "",
            date = seriesDetail.firstAirDate?.split("-")?.firstOrNull() ?: "",
            overview = seriesDetail.overview ?: "",
            onBack = onBack
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
}

@Preview
@Composable
fun PreviewSeriesDetail() {
    MovieComposeTheme(darkTheme = false) {
        DetailSeries(SeriesDetail(), {}) {}
    }
}