package com.marcsedev.moviedb.core.data.remote.dto

data class MovieDtoResponse(
    val dates: Dates,
    val page: Int,
    val results: List<MovieResult>,
    val totalPages: Int,
    val totalResults: Int
)