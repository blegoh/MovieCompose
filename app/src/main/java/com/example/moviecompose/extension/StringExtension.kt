package com.example.moviecompose.extension

fun String.toImageUrl(): String {
    return "https://image.tmdb.org/t/p/w500/$this"
}