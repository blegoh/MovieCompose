package com.example.moviecompose.view

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.moviecompose.data.Movie

@Composable
fun Home() {
    Column {
        MovieHeadline(
            listOf(
                Movie(""),
                Movie(""),
                Movie(""),
            )
        )
        ContinueWatching(
            listOf(
                Movie(""),
                Movie(""),
                Movie(""),
            )
        )
        PopularMovie(
            listOf(
                Movie(""),
                Movie(""),
                Movie(""),
                Movie(""),
                Movie(""),
                Movie(""),
            )
        )
    }
}