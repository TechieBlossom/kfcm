package com.techieblossom.kfcm.ui.composable

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.techieblossom.kfcm.ui.dashIfNullOrBlank

@Composable
fun Value(modifier: Modifier = Modifier, value: String?) {
    Text(
        text = value.dashIfNullOrBlank(),
        textAlign = TextAlign.End,
        style = MaterialTheme.typography.bodyMedium,
        modifier = modifier
    )
}