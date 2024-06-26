package com.marcsedev.moviedb.home.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.marcsedev.moviedb.core.domain.model.Movie
import com.marcsedev.moviedb.home.presentation.FilterType
import com.marcsedev.moviedb.ui.theme.MovieDBTheme

@Composable
fun HomeRecommended(
    selectedFilter: FilterType,
    onFilteredClick: (FilterType) -> Unit,
    movieList: List<Movie>,
    modifier: Modifier = Modifier,
    onMovieClick: (Movie) -> Unit
) {
    if (movieList.isNotEmpty()) {
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            CategoryTitle(title = "Recomendados para ti")
            Spacer(modifier = Modifier.height(16.dp))
            FilterPillContainer(
                filters = FilterType.values().toList(),
                selectedFilter = selectedFilter,
                onFilterClick = onFilteredClick
            )
            Spacer(modifier = Modifier.height(16.dp))


        }
    }
}

@Preview
@Composable
fun HomeRecommendedPreview() {
    MovieDBTheme {
        HomeRecommended(
            selectedFilter = FilterType.SPANISH,
            onFilteredClick = {},
            movieList = emptyList(),
            onMovieClick = {}
        )
    }
}