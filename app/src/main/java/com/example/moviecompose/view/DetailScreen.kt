package com.example.moviecompose.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviecompose.view.items.Detail
import com.example.moviecompose.viewmodels.DetailViewModel

@Composable
fun DetailScreen(id: Int, viewModel: DetailViewModel = hiltViewModel(), onBack: () -> Unit) {
    val movie by viewModel.movie.observeAsState()
    movie?.let {
        Detail(movieDetail = it, onBack = onBack)
    }

    LaunchedEffect(Unit) {
        viewModel.getMovie(id)
    }
}
