package com.example.moviecompose.ui.template

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviecompose.extension.toImageUrl
import com.example.moviecompose.repositories.data.MovieDetail
import com.example.moviecompose.theme.MovieComposeTheme
import com.example.moviecompose.ui.component.Header

@Composable
fun DetailMovie(movieDetail: MovieDetail, onBack: () -> Unit) {
    Column {
        Header(
            cover = movieDetail.backdropPath?.toImageUrl() ?: "",
            title = movieDetail.title ?: "",
            date = movieDetail.releaseDate?.split("-")?.firstOrNull() ?: "",
            overview = movieDetail.overview ?: "",
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