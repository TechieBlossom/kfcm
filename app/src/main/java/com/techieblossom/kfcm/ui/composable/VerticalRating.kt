package com.techieblossom.kfcm.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun VerticalRating(
    label: String, value: Int?, labelStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    valueStyle: TextStyle = MaterialTheme.typography.labelSmall,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Label(label = label, labelStyle = labelStyle)
        RatingValue(value = value, valueStyle = valueStyle)
    }
}

@Composable
fun VerticalRating(
    label: String,
    value: String?,
    labelStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    valueStyle: TextStyle = MaterialTheme.typography.labelSmall,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Label(label = label, labelStyle = labelStyle)
        RatingValue(value = value, valueStyle = valueStyle)
    }
}

@Composable
private fun Label(label: String, labelStyle: TextStyle?) {
    Text(
        text = label,
        style = labelStyle ?: MaterialTheme.typography.bodyMedium,
        color = Color.Black
    )
}

@Preview
@Composable
fun Preview_VerticalRating() {
    FCMTheme {
        Surface {
            VerticalRating(label = "OVR", value = 90)
        }
    }
}

@Preview
@Composable
fun Preview_VerticalRatingWithString() {
    FCMTheme {
        Surface {
            VerticalRating(label = "OVR", value = "90")
        }
    }
}