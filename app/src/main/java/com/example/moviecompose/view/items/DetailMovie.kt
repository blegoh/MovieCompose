package com.example.moviecompose.view.items

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviecompose.repositories.data.MovieDetail
import com.example.moviecompose.theme.MovieComposeTheme

@Composable
fun DetailMovie(movieDetail: MovieDetail, onBack: () -> Unit) {
    Column {
        Header(
            cover = "https://image.tmdb.org/t/p/w500/${movieDetail.backdropPath}",
            title = movieDetail.title ?: "",
            date = movieDetail.releaseDate?.split("-")?.firstOrNull() ?: "",
            overview = movieDetail.overview ?: "",
            onBack = onBack
        )
    }
}

@Preview
@Composable
fun PreviewMovieDetail() {
    MovieComposeTheme(darkTheme = false) {
        DetailMovie(MovieDetail()) {}
    }
}