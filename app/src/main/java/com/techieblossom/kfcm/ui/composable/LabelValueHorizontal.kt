package com.techieblossom.kfcm.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun LabelValueHorizontal(
    modifier: Modifier = Modifier,
    index: Int = 0,
    label: String,
    value: String?,
    applyColor: Boolean = true,
) {
    val bgColor =
        if (index.rem(2) == 1) MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.inversePrimary
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(if (applyColor) bgColor else Color.Transparent)
            .padding(if (applyColor) 8.dp else 0.dp)
    ) {
        Label(label = label, modifier = Modifier.weight(1f))
        Value(value = value, modifier = Modifier.weight(1f))
    }
}

@Preview
@Composable
fun Preview_LabelValueHorizontal_Even() {
    FCMTheme {
        LabelValueHorizontal(index = 0, label = "DOMESTIC PRESTIGE", value = "Spotify Camp Nou")
    }
}

@Preview
@Composable
fun Preview_LabelValueHorizontal_Odd() {
    FCMTheme {
        LabelValueHorizontal(index = 1, label = "DOMESTIC PRESTIGE", value = "Spotify Camp Nou")
    }
}

@Preview
@Composable
fun Preview_LabelValueHorizontal_ApplyColorFalse() {
    FCMTheme {
        LabelValueHorizontal(
            index = 1,
            label = "DOMESTIC PRESTIGE",
            value = "Spotify Camp Nou",
            applyColor = false,
        )
    }
}