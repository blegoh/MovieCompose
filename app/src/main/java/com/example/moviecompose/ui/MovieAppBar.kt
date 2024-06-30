package com.example.moviecompose.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviecompose.theme.MovieComposeTheme
import com.example.moviecompose.theme.TitleColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieAppBar(
    currentScreen: MovieScreen,
    onSearch: () -> Unit
) {
    if (currentScreen != MovieScreen.Detail && currentScreen != MovieScreen.Search) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = currentScreen.title,
                    color = TitleColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                )
            },
            actions = {
                if (currentScreen == MovieScreen.Home) {
                    IconButton(onClick = { onSearch() }) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search"
                        )
                    }
                }
            },
            navigationIcon = {
                if (currentScreen == MovieScreen.Home) {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Search"
                        )
                    }
                }
            }
        )
    }
}

@Preview()
@Composable
fun PreviewMovieAppBar() {
    MovieComposeTheme() {
        MovieAppBar(MovieScreen.Home, {})
    }
}