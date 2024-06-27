package com.example.moviecompose.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.moviecompose.repositories.data.MovieSeries
import com.example.moviecompose.view.items.WatchlistItem

@Composable
fun Watchlist(movies: List<MovieSeries>, onClick: () -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(
            top = 16.dp
        )
    ) {
        items(movies) { movie ->
            WatchlistItem(onClick)
        }
    }
}