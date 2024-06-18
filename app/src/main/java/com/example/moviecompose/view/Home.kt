package com.example.moviecompose.view

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.moviecompose.data.Movie

@Composable
fun Home(onClick: () -> Unit) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
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
        HorizontalPortraitMovies(
            "Popular Movie",
            listOf(
                Movie(""),
                Movie(""),
                Movie(""),
                Movie(""),
                Movie(""),
                Movie(""),
            ), onClick = onClick
        )
        HorizontalPortraitMovies(
            "Popular Series",
            listOf(
                Movie(""),
                Movie(""),
                Movie(""),
                Movie(""),
                Movie(""),
                Movie(""),
            ), onClick = onClick
        )
        HorizontalPortraitMovies(
            "Matched To You",
            listOf(
                Movie(""),
                Movie(""),
                Movie(""),
                Movie(""),
                Movie(""),
                Movie(""),
            ), onClick = onClick
        )
    }
}