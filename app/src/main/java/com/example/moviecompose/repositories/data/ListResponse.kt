package com.example.moviecompose.repositories.data

import com.squareup.moshi.Json

data class ListResponse<T>(

    @field:Json(name = "page")
    val page: Int? = null,

    @field:Json(name = "total_pages")
    val totalPages: Int? = null,

    @field:Json(name = "results")
    val results: List<T>? = null,

    @field:Json(name = "total_results")
    val totalResults: Int? = null
)