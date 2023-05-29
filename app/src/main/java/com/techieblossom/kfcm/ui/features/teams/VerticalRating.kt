package com.techieblossom.kfcm.ui.features.teams

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun VerticalRating(label: String, value: Int?) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Label(label = label)
        RatingValue(value = value)
    }
}

@Composable
private fun Label(label: String) {
    Text(text = label, style = MaterialTheme.typography.bodyMedium, color = Color.Black)
}