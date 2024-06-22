package com.example.moviecompose.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviecompose.repositories.data.MovieDetail
import com.example.moviecompose.theme.MovieComposeTheme
import com.example.moviecompose.view.items.Detail
import com.example.moviecompose.viewmodels.DetailViewModel

@Composable
fun DetailScreen(id: Int, viewModel: DetailViewModel = hiltViewModel(), onBack: () -> Unit) {
    viewModel.movie.value?.let {
        Detail(movieDetail = it, onBack = onBack)
    }

    DisposableEffect(Unit) {
        viewModel.getMovie(id)
        onDispose {}
    }
}
