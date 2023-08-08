package com.techieblossom.kfcm.ui.composable

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Label(modifier: Modifier = Modifier, label: String) {
    Text(text = label, style = MaterialTheme.typography.bodySmall, modifier = modifier)
}