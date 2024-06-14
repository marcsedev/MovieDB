package com.marcsedev.moviedb.core.data.remote.dto

data class MovieDtoResponse(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)