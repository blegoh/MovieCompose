package com.example.moviecompose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviecompose.repositories.data.MovieSeries
import com.example.moviecompose.viewmodels.HomeViewModel


@Composable
fun Home(viewModel: HomeViewModel = hiltViewModel(), onClick: (id: Int, type: Int) -> Unit) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
    ) {
        MovieHeadline(
            listOf(
                MovieSeries(1, "", "", 1)
            ), { }
        )
        ContinueWatching(
            listOf(
                MovieSeries(1, "", "", 1)
            ), { }
        )
        HorizontalPortraitMovies(
            "Popular Movie", viewModel.movies.value, onClick = onClick
        )
        HorizontalPortraitMovies(
            "Popular Series", viewModel.series.value, onClick = onClick
        )
        HorizontalPortraitMovies(
            "Matched To You", listOf(
                MovieSeries(1, "Avatar", "", 1),
            ), onClick = onClick
        )
    }

    DisposableEffect(Unit) {
        viewModel.getMovies()
        viewModel.getSeries()
        onDispose {}
    }
}