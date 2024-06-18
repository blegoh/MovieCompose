package com.example.moviecompose.view.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.example.moviecompose.theme.MovieComposeTheme

@Composable
fun MovieCard() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        val (card) = createRefs()
        Card(modifier = Modifier
            .aspectRatio(1.7778f)
            .width(0.dp)
            .constrainAs(card) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            .padding(16.dp), colors = CardDefaults.cardColors()) {
            ConstraintLayout {
                val (content, surface) = createRefs()
                AsyncImage(
                    model = "https://image.tmdb.org/t/p/original/nLBRD7UPR6GjmWQp6ASAfCTaWKX.jpg",
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Surface(modifier = Modifier
                    .constrainAs(surface) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }
                    .fillMaxWidth(), color = Color(0x40000000)) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "John Wick: Chapter 4",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.White
                        )
                        Row {
                            Text(
                                text = "2 Hours 40 Minutes",
                                style = MaterialTheme.typography.titleSmall,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "8.4",
                                style = MaterialTheme.typography.titleSmall,
                                color = Color.White
                            )
                        }
                    }
                }

            }
        }
    }
}

@Preview()
@Composable
fun PreviewMovieCard() {
    MovieComposeTheme() {
        MovieCard()
    }
}