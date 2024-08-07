package com.example.moviecompose.ui.template

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.moviecompose.R
import com.example.moviecompose.theme.Gray2
import com.example.moviecompose.theme.Gray3
import com.example.moviecompose.theme.MovieComposeTheme
import com.example.moviecompose.ui.component.MovieGenre

@Composable
fun WatchlistItem(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .height(134.dp)
            .padding(horizontal = 16.dp)
            .padding(bottom = 8.dp)
            .clickable {
                onClick()
            },
    ) {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/original/nLBRD7UPR6GjmWQp6ASAfCTaWKX.jpg",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(100.dp)
                .fillMaxHeight()
                .clip(RoundedCornerShape(5.dp))
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Rurouni Kenshin : The Final",
                color = Gray2,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            MovieGenre(genres = listOf("Action", "Comedy"), modifier = Modifier.padding(top = 8.dp))
            Text(
                text = "1h 35m",
                fontSize = 10.sp,
                color = Gray3,
                modifier = Modifier.padding(top = 8.dp)
            )
            Row(
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.watchlist), contentDescription = "",
                    modifier = Modifier.height(14.dp)
                )
                Text(
                    text = "Remove from Watchlist",
                    fontSize = 10.sp,
                    color = Gray3,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Preview()
@Composable
fun PreviewMovieWatchlist() {
    MovieComposeTheme {
        WatchlistItem {}
    }
}