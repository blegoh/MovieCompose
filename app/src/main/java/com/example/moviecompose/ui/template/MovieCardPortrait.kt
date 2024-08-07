package com.example.moviecompose.ui.template

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.moviecompose.extension.toImageUrl
import com.example.moviecompose.repositories.data.MovieSeries
import com.example.moviecompose.theme.MovieComposeTheme
import com.example.moviecompose.ui.component.MovieGenre

@Composable
fun MovieCardPortrait(movie: MovieSeries, onClick: (id: Int, type: Int) -> Unit) {
    Column(modifier = Modifier.padding(8.dp)) {
        Card(
            modifier = Modifier
                .width(130.dp)
                .height(210.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            onClick = {
                onClick(movie.id, movie.type)
            },
            shape = RoundedCornerShape(4.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 1.dp
            )
        ) {
            Column {
                AsyncImage(
                    model = movie.poster.toImageUrl(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(140.dp)
                        .padding(horizontal = 4.dp)
                        .padding(top = 4.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(2.dp))
                )
                Text(
                    text = movie.title.toString(),
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .padding(top = 4.dp),
                    maxLines = 2,
                    lineHeight = 13.sp,
                    fontSize = 14.sp,
                    overflow = TextOverflow.Ellipsis
                )
                MovieGenre(
                    genres = listOf("Action", "Comedy"),
                    modifier = Modifier.padding(start = 4.dp, top = 4.dp)
                )
            }
        }
    }
}

@Preview()
@Composable
fun PreviewMovieCardPortrait() {
    MovieComposeTheme() {
        MovieCardPortrait(MovieSeries(1, "", "", 1), onClick = { _, _ ->

        })
    }
}