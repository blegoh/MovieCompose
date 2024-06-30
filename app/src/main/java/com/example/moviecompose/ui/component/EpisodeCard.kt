package com.example.moviecompose.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.moviecompose.extension.toImageUrl
import com.example.moviecompose.theme.Gray2
import com.example.moviecompose.theme.Gray3
import com.example.moviecompose.theme.MovieComposeTheme

@Composable
fun EpisodeCard(
    cover: String,
    episode: Int,
    overview: String,
    onClick: () -> Unit,
) {
    Column {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 8.dp)
                .fillMaxWidth()
                .clickable {
                    onClick()
                },
        ) {
            AsyncImage(
                model = cover.toImageUrl(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(130.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(5.dp))
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = "Episode $episode",
                    color = Gray2,
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "1h 35m",
                    fontSize = 10.sp,
                    lineHeight = 14.sp,
                    color = Gray3,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
        Text(
            text = overview,
            color = Gray3,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp)
        )
    }
}

@Preview()
@Composable
fun PreviewEpisode() {
    MovieComposeTheme(darkTheme = false, dynamicColor = false) {
        EpisodeCard(
            cover = "",
            episode = 1,
            overview = "As life at the hospital goes on, the five friends' growing pains continue. Gyeo-ul is disquieted by frequent visits from a patient's mother."
        ) {}
    }
}