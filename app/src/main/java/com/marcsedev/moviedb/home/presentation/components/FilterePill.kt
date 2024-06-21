package com.marcsedev.moviedb.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.marcsedev.moviedb.home.presentation.FilterType
import com.marcsedev.moviedb.ui.theme.Background


@Composable
fun FilterPill(
    filterType: FilterType,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) Color.White else Background
    val textColor = if (isSelected) Background else Color.White

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .clickable { onClick() }
            .border(width = 0.5.dp, color = Color.White, shape = RoundedCornerShape(36.dp))
            .background(backgroundColor)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = filterType.text,
            color = textColor,
        )
    }
}

@Preview
@Composable
fun FilteredButtonTruePreview() {
    FilterPill(
        filterType = FilterType.SPANISH,
        isSelected = true,
        onClick = {}
    )
}

@Preview
@Composable
fun FilteredButtonFalsePreview() {
    FilterPill(
        filterType = FilterType.SPANISH,
        isSelected = false,
        onClick = {}
    )
}