package com.techieblossom.kfcm.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun Heading(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Left,
    hasBgColor: Boolean = false,
) {
    if (hasBgColor) {
        Box(modifier = modifier.background(MaterialTheme.colorScheme.inversePrimary)) {
            Text(text, modifier, textAlign)
        }
    } else {
        Text(text, modifier, textAlign)
    }
}

@Composable
private fun Text(
    text: String,
    modifier: Modifier,
    textAlign: TextAlign,
) {
    Text(
        text,
        style = MaterialTheme.typography.titleMedium,
        modifier = modifier
            .padding(bottom = 4.dp)
            .fillMaxWidth(),
        textAlign = textAlign,
    )
}

@Preview
@Composable
fun Preview_Heading() {
    FCMTheme {
        Surface {
            Heading("DEFENCE")
        }
    }
}

@Preview
@Composable
fun Preview_HeadingWithBG() {
    FCMTheme {
        Surface {
            Heading("DEFENCE", hasBgColor = true)
        }
    }
}