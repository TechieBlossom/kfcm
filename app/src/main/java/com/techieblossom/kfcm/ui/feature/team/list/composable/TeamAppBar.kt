package com.techieblossom.kfcm.ui.feature.team.list.composable

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techieblossom.kfcm.R
import com.techieblossom.kfcm.ui.theme.FCMTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamAppBar(onSearchTapped: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.teams),
                style = MaterialTheme.typography.titleLarge
            )
        },
        actions = {
            IconButton(onClick = onSearchTapped) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search by team name",
                    tint = Color.Black,
                )
            }
        }
    )
}

@Preview
@Composable
fun Preview_TeamAppBar() {
    FCMTheme {
        Surface {
            TeamAppBar(onSearchTapped = {})
        }
    }
}