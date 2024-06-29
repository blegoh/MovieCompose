package com.example.moviecompose.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviecompose.view.items.DetailMovie
import com.example.moviecompose.view.items.DetailSeries
import com.example.moviecompose.viewmodels.DetailViewModel

@Composable
fun DetailScreen(
    id: Int, type: Int, viewModel: DetailViewModel = hiltViewModel(), onBack: () -> Unit
) {
    val movie by viewModel.movie.observeAsState()
    val series by viewModel.series.observeAsState()
    movie?.let {
        DetailMovie(movieDetail = it, onBack = onBack)
    }
    series?.let {
        DetailSeries(seriesDetail = it, onBack = onBack, onSeasonClick = { season ->
            viewModel.getSeason(id, season)
        })
    }

    LaunchedEffect(Unit) {
        if (type == 1) viewModel.getMovie(id)
        else viewModel.getSeries(id)
    }
}
