package com.example.moviecompose.repositories.data

import com.squareup.moshi.Json

data class Season(

    @field:Json(name = "air_date")
    val airDate: String? = null,

    @field:Json(name = "overview")
    val overview: String? = null,

    @field:Json(name = "episode_count")
    val episodeCount: Int? = null,

    @field:Json(name = "vote_average")
    val voteAverage: Double? = null,

    @field:Json(name = "name")
    val name: String? = null,

    @field:Json(name = "season_number")
    val seasonNumber: Int,

    @field:Json(name = "id")
    val id: Int,

    @field:Json(name = "poster_path")
    val posterPath: String? = null
)