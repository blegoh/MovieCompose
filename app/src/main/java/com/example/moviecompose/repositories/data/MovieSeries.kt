package com.example.moviecompose.repositories.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieSeries(

	@field:Json(name="overview")
	val overview: String? = null,

	@field:Json(name="original_language")
	val originalLanguage: String? = null,

	@field:Json(name="original_title")
	val originalTitle: String? = null,

	@field:Json(name="video")
	val video: Boolean? = null,

	@field:Json(name="title")
	val title: String? = null,

	@field:Json(name="genre_ids")
	val genreIds: List<Int?>? = null,

	@field:Json(name="poster_path")
	val posterPath: String? = null,

	@field:Json(name="backdrop_path")
	val backdropPath: String? = null,

	@field:Json(name="release_date")
	val releaseDate: String? = null,

	@field:Json(name="popularity")
	val popularity: Double? = null,

	@field:Json(name="vote_average")
	val voteAverage: Double? = null,

	@field:Json(name="id")
	val id: Int? = null,

	@field:Json(name="adult")
	val adult: Boolean? = null,

	@field:Json(name="vote_count")
	val voteCount: Int? = null
) : Parcelable