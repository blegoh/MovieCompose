package com.example.moviecompose.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviecompose.data.Movie
import com.example.moviecompose.theme.MovieComposeTheme

@Composable
fun PopularMovie(movies: List<Movie>, onClick: () -> Unit) {
    Column {
        Text(
            text = "Trending",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 16.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(
                end = 8.dp,
                start = 8.dp
            )
        ) {
            items(movies) { movie ->
                MovieCardPortrait(onClick = onClick)
            }
        }
        Spacer(modifier = Modifier.padding(4.dp))
    }
}

@Preview()
@Composable
fun PopularMovie() {
    MovieComposeTheme() {
        PopularMovie(
            listOf(
                Movie(""),
                Movie(""),
                Movie(""),
            )
        ) {

        }
    }
}