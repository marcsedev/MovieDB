package com.marcsedev.moviedb.core.data

import com.marcsedev.moviedb.core.data.remote.dto.MovieDtoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface  MovieApi {
    companion object{
        const val IMAGE_URL = "https://image.tmdb.org/t/p/original/"
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }

    @GET("movie/upcoming") //TODO: Pagination
    suspend fun getUpcomingMovies(@Query("api_key") apiKey: String): MovieDtoResponse

    @GET("movie/popular") //TODO: Pagination
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): MovieDtoResponse
}