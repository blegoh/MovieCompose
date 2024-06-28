package com.example.moviecompose.repositories.data

import com.squareup.moshi.Json

data class NetworksItem(

	@field:Json(name="logo_path")
	val logoPath: String? = null,

	@field:Json(name="name")
	val name: String? = null,

	@field:Json(name="id")
	val id: Int? = null,

	@field:Json(name="origin_country")
	val originCountry: String? = null
)