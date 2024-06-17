package com.marcsedev.moviedb.core.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieDtoResponse(
    val dates: Dates,
    val page: Int,
    val results: List<MovieResult>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)
