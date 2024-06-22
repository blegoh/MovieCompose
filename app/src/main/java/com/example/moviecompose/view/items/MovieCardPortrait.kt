package com.example.moviecompose.view.items

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.example.moviecompose.repositories.data.MovieSeries
import com.example.moviecompose.theme.MovieComposeTheme
import com.example.moviecompose.view.MovieGenre

@Composable
fun MovieCardPortrait(movie: MovieSeries, onClick: () -> Unit) {
    Log.d("cek123","https://image.tmdb.org/t/p/w500/${movie.posterPath}")
    Column(modifier = Modifier.padding(8.dp)) {
        Card(
            modifier = Modifier
                .width(130.dp)
                .height(210.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            onClick = onClick,
            shape = RoundedCornerShape(4.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 1.dp
            )
        ) {
            Column {
                AsyncImage(
                    model = "https://image.tmdb.org/t/p/w500/${movie.posterPath}",
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
        MovieCardPortrait(MovieSeries(), onClick = {})
    }
}