package com.example.moviecompose.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.example.moviecompose.theme.MovieComposeTheme

@Composable
fun MovieCardPortrait() {
    Column(modifier = Modifier.padding(8.dp)) {
        Card(
            modifier = Modifier
                .width(135.dp)
                .height(240.dp),
            colors = CardDefaults.cardColors()
        ) {
            ConstraintLayout {
                AsyncImage(
                    model = "https://image.tmdb.org/t/p/original/nLBRD7UPR6GjmWQp6ASAfCTaWKX.jpg",
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Preview()
@Composable
fun PreviewMovieCardPortrait() {
    MovieComposeTheme() {
        MovieCardPortrait()
    }
}