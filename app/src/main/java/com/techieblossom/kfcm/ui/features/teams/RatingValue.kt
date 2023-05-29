package com.techieblossom.kfcm.ui.features.teams

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techieblossom.kfcm.ui.theme.FCMTheme
import com.techieblossom.kfcm.ui.theme.rating1
import com.techieblossom.kfcm.ui.theme.rating2
import com.techieblossom.kfcm.ui.theme.rating3
import com.techieblossom.kfcm.ui.theme.rating4
import com.techieblossom.kfcm.ui.theme.rating5

@Composable
fun RatingValue(value: Int?) {
    val color = calculateColor(value)
    Box(
        modifier = Modifier
            .size(20.dp)
            .border(width = 2.dp, color, shape = RoundedCornerShape(2.dp))
            .padding(1.dp)
            .background(color),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = (value ?: 0).toString(),
            style = MaterialTheme.typography.labelSmall,
            color = Color.Black,
            modifier = Modifier.fillMaxSize(),
            textAlign = TextAlign.Center
        )
    }
}

private fun calculateColor(value: Int?): Color {
    if (value == null) return rating1

    return when {
        value >= 81 -> rating5
        value >= 71 -> rating4
        value >= 61 -> rating3
        value >= 51 -> rating2
        else -> rating1
    }
}


@Preview
@Composable
fun PreviewRatingValue() {
    FCMTheme {
        RatingValue(82)
    }
}