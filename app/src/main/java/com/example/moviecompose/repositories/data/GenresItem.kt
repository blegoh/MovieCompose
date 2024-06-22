package com.example.moviecompose.repositories.data

import com.squareup.moshi.Json

data class GenresItem(

	@field:Json(name="name")
	val name: String? = null,

	@field:Json(name="id")
	val id: Int? = null
)