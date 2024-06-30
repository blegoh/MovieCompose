package com.example.moviecompose.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviecompose.ui.items.DetailMovie
import com.example.moviecompose.ui.items.DetailSeries
import com.example.moviecompose.viewmodels.DetailViewModel

@Composable
fun DetailScreen(
    id: Int, type: Int, viewModel: DetailViewModel = hiltViewModel(), onBack: () -> Unit
) {
    val movie by viewModel.movie.observeAsState()
    val series by viewModel.series.observeAsState()
    val season by viewModel.season.observeAsState()
    movie?.let {
        DetailMovie(movieDetail = it, onBack = onBack)
    }
    series?.let {
        DetailSeries(
            seriesDetail = it,
            seasonDetail = season,
            onBack = onBack,
            onSeasonClick = { season ->
                viewModel.getSeason(id, season)
            })
    }

    LaunchedEffect(Unit) {
        if (type == 1) viewModel.getMovie(id)
        else viewModel.getSeries(id)
    }
}
