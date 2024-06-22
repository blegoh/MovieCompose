package com.example.moviecompose.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviecompose.R
import com.example.moviecompose.theme.GenreBg
import com.example.moviecompose.theme.GenreText
import com.example.moviecompose.theme.MovieComposeTheme

@Composable
fun MovieGenre(genres: List<String>, modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(
            dimensionResource(id = R.dimen.dimen_4dp)
        ),
        modifier = modifier
    ) {
        items(genres) { genre ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
            ) {
                FilterChip(onClick = {}, label = {
                    Text(
                        text = genre,
                        fontSize = 8.sp,
                        textAlign = TextAlign.Center,
                    )
                }, leadingIcon = null, selected = true,
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = GenreBg,
                        selectedLabelColor = GenreText
                    ),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.fillMaxHeight()
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewMovieGenre() {
    MovieComposeTheme(darkTheme = false) {
        MovieGenre(listOf("Action", "Comedy", "Adventure"), Modifier.padding(0.dp))
    }
}