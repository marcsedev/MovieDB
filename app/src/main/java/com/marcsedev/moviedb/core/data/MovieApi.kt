package com.marcsedev.moviedb.core.data

import com.marcsedev.moviedb.core.data.remote.dto.MovieDtoResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface  MovieApi {
    companion object{
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }

    @GET("movie/upcoming") //TODO: Pagination
    suspend fun getUpcomingMovies(@Query("api_key") apiKey: String): MovieDtoResponse
}