package com.marcsedev.moviedb.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.marcsedev.moviedb.home.presentation.FilterType
import com.marcsedev.moviedb.ui.theme.MovieDBTheme

@Composable
fun FilterPillContainer(
    filters: List<FilterType>,
    selectedFilter: FilterType,
    modifier: Modifier = Modifier,
    onFilterClick: (FilterType) -> Unit
) {
    LazyRow(
        //modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(filters) {
            FilterPill(
                filterType = it,
                isSelected = selectedFilter == it
            ) {
                onFilterClick(it)
            }
        }
    }
}

@Preview
@Composable
fun FilterPillContainerPreview() {
    MovieDBTheme {
        FilterPillContainer(
            filters = listOf(FilterType.SPANISH, FilterType.FOR_YOU),
            selectedFilter = FilterType.SPANISH,
            onFilterClick = {}
        )
    }
}