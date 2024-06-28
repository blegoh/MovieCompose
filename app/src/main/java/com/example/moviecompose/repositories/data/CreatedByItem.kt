package com.example.moviecompose.repositories.data

import com.squareup.moshi.Json

data class CreatedByItem(

	@field:Json(name="gender")
	val gender: Int? = null,

	@field:Json(name="credit_id")
	val creditId: String? = null,

	@field:Json(name="original_name")
	val originalName: String? = null,

	@field:Json(name="name")
	val name: String? = null,

	@field:Json(name="profile_path")
	val profilePath: String? = null,

	@field:Json(name="id")
	val id: Int? = null
)