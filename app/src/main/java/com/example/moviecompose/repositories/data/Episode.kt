package com.example.moviecompose.repositories.data

import com.squareup.moshi.Json

data class Episode(

	@field:Json(name="episode_type")
	val episodeType: String? = null,

	@field:Json(name="production_code")
	val productionCode: String? = null,

	@field:Json(name="overview")
	val overview: String? = null,

	@field:Json(name="show_id")
	val showId: Int? = null,

	@field:Json(name="season_number")
	val seasonNumber: Int? = null,

	@field:Json(name="runtime")
	val runtime: Int? = null,

	@field:Json(name="still_path")
	val stillPath: String? = null,

	@field:Json(name="crew")
	val crew: List<Crew?>? = null,

	@field:Json(name="guest_stars")
	val guestStars: List<GuestStar?>? = null,

	@field:Json(name="air_date")
	val airDate: String? = null,

	@field:Json(name="episode_number")
	val episodeNumber: Int? = null,

	@field:Json(name="vote_average")
	val voteAverage: Double? = null,

	@field:Json(name="name")
	val name: String? = null,

	@field:Json(name="id")
	val id: Int? = null,

	@field:Json(name="vote_count")
	val voteCount: Int? = null
)