package com.marcsedev.moviedb.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Background = Color(0xFF1E1E1E)

val gradientColors = Brush.linearGradient(
    colors = listOf(
        Color(0x50800606), // startColor
        Color(0x50000000)  // endColor
    ),
    start = androidx.compose.ui.geometry.Offset(0f, 0f), // Start at the top
    end = androidx.compose.ui.geometry.Offset(0f, Float.POSITIVE_INFINITY) // End at the bottom
)
