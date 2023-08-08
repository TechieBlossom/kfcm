package com.techieblossom.kfcm.ui.features.team.list.screen

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
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
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.techieblossom.kfcm.ui.features.team.list.composable.TeamAppBar
import com.techieblossom.kfcm.ui.features.team.list.composable.TeamCard
import com.techieblossom.kfcm.ui.features.team.list.model.ListState
import com.techieblossom.kfcm.ui.features.team.list.viewModel.TeamScreenViewModel
import com.techieblossom.kfcm.ui.theme.FCMTheme

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TeamScreen(onTeamSelected: (teamId: Int) -> Unit) {
    val viewModel = viewModel<TeamScreenViewModel>()
    val teamUiState by viewModel.teamUiState.collectAsState()
    val lazyStaggeredGridState = rememberLazyStaggeredGridState()
    val shouldStartPaginate = remember {
        derivedStateOf {
            viewModel.canPaginate && (lazyStaggeredGridState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
                ?: -9) >= (lazyStaggeredGridState.layoutInfo.totalItemsCount - 4)
        }
    }

    LaunchedEffect(key1 = shouldStartPaginate.value) {
        Log.i("Launched Effect", shouldStartPaginate.value.toString())
        if (shouldStartPaginate.value && viewModel.teamUiState.value.listState == ListState.IDLE) {
            viewModel.loadTeams()
        }
    }

    Scaffold(
        topBar = { TeamAppBar() },
        contentWindowInsets = WindowInsets(left = 8.dp, right = 8.dp),
    ) { contentPadding ->
        Box {
            SearchComponent(
                modifier = Modifier
                    .padding(contentPadding)
                    .fillMaxWidth()
            ) {
                viewModel.onSearch(it)
            }
            LazyVerticalStaggeredGrid(
                state = lazyStaggeredGridState,
                columns = StaggeredGridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalItemSpacing = 8.dp,
                modifier = Modifier
                    .padding(contentPadding)
                    .padding(top = 50.dp),
            ) {
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
                        OutlinedCard(
                            modifier = Modifier.size(100.dp),
                            border = BorderStroke(
                                width = 2.dp,
                                color = MaterialTheme.colorScheme.outlineVariant
                            ),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun SearchComponent(modifier: Modifier = Modifier, onSearch: (searchTerm: String) -> Unit) {
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
                    it()
                }
            }
        },
    )
}


@Preview(
    device = "spec:width=1080px,height=2400px,dpi=480",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE
)
@Composable
fun Preview_TeamScreen() {
    FCMTheme {
        TeamScreen {

        }
    }
}