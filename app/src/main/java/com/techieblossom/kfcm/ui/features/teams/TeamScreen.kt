package com.techieblossom.kfcm.ui.features.teams

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import com.techieblossom.kfcm.R
import com.techieblossom.kfcm.previewMocks.teamForCard
import com.techieblossom.kfcm.ui.theme.FCMTheme

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TeamScreen() {
    val teams = listOf(
        teamForCard, teamForCard, teamForCard, teamForCard, teamForCard, teamForCard,
        teamForCard, teamForCard, teamForCard, teamForCard, teamForCard, teamForCard,
        teamForCard, teamForCard, teamForCard, teamForCard, teamForCard, teamForCard,
        teamForCard, teamForCard, teamForCard, teamForCard, teamForCard, teamForCard,
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.teams))
                },
            )
        },
        contentWindowInsets = WindowInsets(left = 8.dp, right = 8.dp),
    ) { contentPadding ->
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalItemSpacing = 8.dp,
            modifier = Modifier.padding(contentPadding)
        ) {
            items(teams.size) {
                TeamCard(team = teams[it])
            }
        }
    }

}

@Preview(
    device = "spec:width=1080px,height=2400px,dpi=480",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE
)
@Composable
fun TeamScreenPreview() {
    FCMTheme {
        TeamScreen()
    }
}