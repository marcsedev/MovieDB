package com.marcsedev.moviedb.home.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marcsedev.moviedb.R

@Composable
fun CustomTitleHomeText()  {
    Box(
        modifier = Modifier
            .border(
                BorderStroke(width = 2.dp, color = Color.White),
            )
    ) {
        Text(
            text = stringResource(R.string.emovie),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(4.dp), // Espaciado interno
            textAlign = TextAlign.Center
        )
    }
}