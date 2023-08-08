package com.techieblossom.kfcm.ui.features.team.list.composable

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.techieblossom.kfcm.R
import com.techieblossom.kfcm.ui.theme.FCMTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamAppBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.teams),
                style = MaterialTheme.typography.titleLarge
            )
        },

        )
}

@Preview
@Composable
fun Preview_TeamAppBar() {
    FCMTheme {
        TeamAppBar()
    }
}