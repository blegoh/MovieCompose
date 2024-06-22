package com.example.moviecompose.repositories.source.remote

import com.example.moviecompose.repositories.data.ListResponse
import retrofit2.http.GET

interface ApiService {

    @GET("/3/movie/popular")
    suspend fun popularMovie(): ListResponse
}