package com.example.moviecompose.repositories.source.remote

import com.example.moviecompose.repositories.data.ListResponse
import com.example.moviecompose.repositories.data.Movie
import com.example.moviecompose.repositories.data.MovieDetail
import com.example.moviecompose.repositories.data.SeasonDetail
import com.example.moviecompose.repositories.data.Series
import com.example.moviecompose.repositories.data.SeriesDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/3/movie/popular")
    suspend fun popularMovie(): ListResponse<Movie>

    @GET("/3/tv/popular")
    suspend fun popularSeries(): ListResponse<Series>

    @GET("/3/movie/{id}")
    suspend fun detailMovie(
        @Path("id") id: Int
    ): MovieDetail

    @GET("/3/tv/{id}")
    suspend fun detailSeries(
        @Path("id") id: Int
    ): SeriesDetail

    @GET("/3/tv/{id}/season/{season}")
    suspend fun detailSeason(
        @Path("id") id: Int,
        @Path("season") season: Int
    ): SeasonDetail
}