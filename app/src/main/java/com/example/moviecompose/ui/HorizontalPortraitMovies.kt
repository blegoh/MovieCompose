package com.example.moviecompose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviecompose.repositories.data.MovieSeries
import com.example.moviecompose.theme.Gray3
import com.example.moviecompose.theme.MovieComposeTheme
import com.example.moviecompose.ui.items.MovieCardPortrait

@Composable
fun HorizontalPortraitMovies(
    title: String,
    movies: List<MovieSeries>,
    onClick: (id: Int, type: Int) -> Unit
) {
    Column {
        Text(
            text = title,
            fontSize = 16.sp,
            color = Gray3,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 21.sp,
            modifier = Modifier.padding(start = 16.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(
                end = 8.dp,
                start = 8.dp
            )
        ) {
            items(movies) { movie ->
                MovieCardPortrait(movie, onClick = onClick)
            }
        }
        Spacer(modifier = Modifier.padding(4.dp))
    }
}

@Preview()
@Composable
fun PopularMovie() {
    MovieComposeTheme() {
        HorizontalPortraitMovies(
            "Trending",
            listOf(
                MovieSeries(1, "", "", 1)
            )
        ) { _, _ ->

        }
    }
}