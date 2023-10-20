package com.techieblossom.kfcm.ui.feature.team.list.screen

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.techieblossom.kfcm.ui.feature.model.ListState
import com.techieblossom.kfcm.ui.feature.team.list.composable.ShimmerTeamCard
import com.techieblossom.kfcm.ui.feature.team.list.composable.TeamAppBar
import com.techieblossom.kfcm.ui.feature.team.list.composable.TeamCard
import com.techieblossom.kfcm.ui.feature.team.list.viewModel.TeamScreenViewModel
import com.techieblossom.kfcm.ui.theme.FCMTheme

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TeamScreen(onSearchTapped: () -> Unit, onTeamSelected: (teamId: Int) -> Unit) {
    val viewModel = viewModel<TeamScreenViewModel>()
    val teamUiState by viewModel.teamUiState.collectAsState()
    val lazyStaggeredGridState = rememberLazyStaggeredGridState()
    val shouldStartPaginate = remember {
        derivedStateOf {
            viewModel.canPaginate && (lazyStaggeredGridState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
                ?: -9) >= (lazyStaggeredGridState.layoutInfo.totalItemsCount - 4)
        }
    }
    val teamGridVisibleState by remember {
        mutableStateOf(derivedStateOf { teamUiState.teams.isNotEmpty() })
    }

    LaunchedEffect(key1 = shouldStartPaginate.value) {
        Log.i("Launched Effect", shouldStartPaginate.value.toString())
        if (shouldStartPaginate.value && viewModel.teamUiState.value.listState == ListState.IDLE) {
            viewModel.loadTeams()
        }
    }

    Scaffold(
        topBar = { TeamAppBar(onSearchTapped = onSearchTapped) },
        contentWindowInsets = WindowInsets(left = 8.dp, right = 8.dp),
    ) { contentPadding ->
        Box {
            LazyVerticalStaggeredGrid(
                state = lazyStaggeredGridState,
                columns = StaggeredGridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalItemSpacing = 8.dp,
                modifier = Modifier
                    .padding(contentPadding)
            ) {
                if (teamUiState.teams.isEmpty()) {
                    items(8) {
                        ShimmerTeamCard()
                    }
                }
                items(teamUiState.teams.size) {
                    TeamCard(
                        team = teamUiState.teams[it],
                        modifier = Modifier.clickable {
                            onTeamSelected(teamUiState.teams[it].id)
                        },
                    )
                }
                item {
                    if (teamUiState.listState == ListState.PAGINATING) {
                        ShimmerTeamCard()
                    }
                }
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
fun Preview_TeamScreen() {
    FCMTheme {
        TeamScreen(onSearchTapped = {}, onTeamSelected = {})
    }
}