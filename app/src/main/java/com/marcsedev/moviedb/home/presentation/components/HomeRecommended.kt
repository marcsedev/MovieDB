package com.marcsedev.moviedb.home.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.marcsedev.moviedb.core.domain.model.Movie
import com.marcsedev.moviedb.home.presentation.FilterType

@Composable
fun HomeRecommended(
    selectedFilter: FilterType,
    onFilteredClick: (FilterType) -> Unit,
    movieList: List<Movie>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth()
    ) {
        item {
            CategoryTitle(title = "Recomendados para ti")
        }
        item {
            FilterPillContainer(
                filters = FilterType.values().toList(),
                selectedFilter =selectedFilter,
                onFilterClick = onFilteredClick
            )
        }
    }
}