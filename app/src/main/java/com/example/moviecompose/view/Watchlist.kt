package com.example.moviecompose.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.moviecompose.data.Movie

@Composable
fun Watchlist(movies: List<Movie>, onClick: () -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(
            top = 16.dp
        )
    ) {
        items(movies) { movie ->
            WatchlistItem()
        }
    }
}