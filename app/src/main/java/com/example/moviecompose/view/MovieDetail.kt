package com.example.moviecompose.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.moviecompose.theme.Blue1
import com.example.moviecompose.theme.GenreBg
import com.example.moviecompose.theme.GenreText
import com.example.moviecompose.theme.Gray2
import com.example.moviecompose.theme.Gray3
import com.example.moviecompose.theme.MovieComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetail() {
    Column {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/original/nLBRD7UPR6GjmWQp6ASAfCTaWKX.jpg",
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.778f)
        )
        Text(
            text = "John Wick: Chapter 4", style = TextStyle(
                fontSize = 24.sp, lineHeight = 28.sp
            ), color = Gray2, modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
        )
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(text = "2024", color = Gray3)
            Text(text = "1 hr 34m", color = Gray3)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue1,
                contentColor = Color.White,
            ),
            shape = RoundedCornerShape(4.dp),
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play",
                modifier = Modifier.size(24.dp)  // Set the size of the icon
            )
            Text("Watch Now")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Row(
            Modifier
                .padding(top = 8.dp)
                .padding(horizontal = 16.dp)
        ) {
            FilterChip(onClick = {}, label = {
                Text("Action")
            }, leadingIcon = null, selected = true,
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = GenreBg,
                    selectedLabelColor = GenreText
                ),
                shape = RoundedCornerShape(20.dp)
            )
            FilterChip(
                onClick = {},
                label = {
                    Text("Action")
                },
                leadingIcon = null,
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = GenreBg,
                    selectedLabelColor = GenreText
                ),
                selected = true,
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding(start = 4.dp)
            )
            FilterChip(
                onClick = {},
                label = {
                    Text("Action")
                },
                leadingIcon = null,
                selected = true,
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = GenreBg,
                    selectedLabelColor = GenreText
                ),
                modifier = Modifier.padding(start = 4.dp),
                shape = RoundedCornerShape(20.dp)
            )
        }
    }
}

@Preview()
@Composable
fun PreviewMovieDetail() {
    MovieComposeTheme(darkTheme = false) {
        MovieDetail()
    }
}