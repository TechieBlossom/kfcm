package com.techieblossom.kfcm.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.techieblossom.kfcm.ui.dashIfNullOrBlank
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun LabelValueVertical(label: String, value: String?) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Label(label = label)
        Value(value = value)
    }
}

@Composable
private fun Label(label: String) {
    Text(text = label, style = MaterialTheme.typography.bodyMedium, color = Color.Black)
}

@Composable
private fun Value(value: String?) {
    Text(text = value.dashIfNullOrBlank(), style = MaterialTheme.typography.labelSmall, color = Color.Black)
}

@Preview
@Composable
fun Preview_LabelValueVertical() {
    FCMTheme {
        LabelValueVertical(label = "WORTH", value = "€4.4B")
    }
}