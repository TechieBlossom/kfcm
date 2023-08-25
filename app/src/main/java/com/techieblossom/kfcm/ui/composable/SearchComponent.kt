package com.techieblossom.kfcm.ui.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun SearchComponent(modifier: Modifier = Modifier, hint: String, onSearch: (searchTerm: String) -> Unit) {
    var searchTerm by remember { mutableStateOf("") }

    BasicTextField(
        modifier = modifier
            .background(Color.Transparent)
            .fillMaxWidth(),
        value = searchTerm,
        onValueChange = {
            searchTerm = it
            onSearch(searchTerm)
        },
        singleLine = true,
        textStyle = MaterialTheme.typography.bodySmall,
        maxLines = 1,
        decorationBox = {
            val bgColor = MaterialTheme.colorScheme.inverseOnSurface
            Column(
                modifier = Modifier
                    .drawWithContent {
                        drawRoundRect(
                            color = bgColor,
                            topLeft = Offset(0f, 0f),
                            cornerRadius = CornerRadius(16f, 16f)
                        )
                        drawContent()
                    }
                    .padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = Icons.Rounded.Search,
                        contentDescription = null,
                        tint = Color.Black,
                    )
                    Box(modifier = Modifier.padding(bottom = 4.dp)) {
                        this@Row.AnimatedVisibility(visible = searchTerm.isBlank()) {
                            Text(
                                text = hint,
                                style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray),
                            )
                        }
                        it()
                    }
                }
            }
        },
    )
}

@Preview
@Composable
fun Preview_SearchComponent() {
    FCMTheme {
        Surface {
            SearchComponent(onSearch = {}, hint = "Barcelona, Real Madrid...")
        }
    }
}