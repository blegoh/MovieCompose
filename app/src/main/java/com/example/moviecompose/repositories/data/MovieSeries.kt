package com.example.moviecompose.repositories.data

data class MovieSeries(
    val id: Int,
    val title: String,
    val poster: String,
    // 1 = movie, 2 = series
    val type: Int
)
