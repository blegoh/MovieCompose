package com.example.moviecompose.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviecompose.repositories.data.Movie
import com.example.moviecompose.repositories.data.MovieSeries
import com.example.moviecompose.viewmodels.HomeViewModel


@Composable
fun Home(viewModel: HomeViewModel = hiltViewModel(), onClick: (id: Int) -> Unit) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
    ) {
        MovieHeadline(
            listOf(
                Movie(""),
                Movie(""),
                Movie(""),
            ), { }
        )
        ContinueWatching(
            listOf(
                Movie(""),
                Movie(""),
                Movie(""),
            ), { }
        )
        HorizontalPortraitMovies(
            "Popular Movie", viewModel.movies.value, onClick = onClick
        )
        HorizontalPortraitMovies(
            "Popular Series", listOf(
                MovieSeries(""),
                MovieSeries(""),
                MovieSeries(""),
                MovieSeries(""),
                MovieSeries(""),
                MovieSeries(""),
            ), onClick = { }
        )
        HorizontalPortraitMovies(
            "Matched To You", listOf(
                MovieSeries(""),
                MovieSeries(""),
                MovieSeries(""),
                MovieSeries(""),
                MovieSeries(""),
                MovieSeries(""),
            ), onClick = { }
        )
    }

    DisposableEffect(Unit) {
        viewModel.getMovies()
        onDispose {}
    }
}