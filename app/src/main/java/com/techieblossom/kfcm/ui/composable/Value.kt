package com.techieblossom.kfcm.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.techieblossom.kfcm.ui.theme.FCMTheme
import com.techieblossom.kfcm.utility.domain.dashIfNullOrBlank

@Composable
fun Value(modifier: Modifier = Modifier, textAlign: TextAlign, value: String?) {
    Text(
        text = value.dashIfNullOrBlank(),
        textAlign = textAlign,
        style = MaterialTheme.typography.bodyMedium,
        modifier = modifier
    )
}

@Preview
@Composable
fun Preview_Value() {
    FCMTheme {
        Surface {
            Value(
                textAlign = TextAlign.End,
                value = "Spotify Camp Nou",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}