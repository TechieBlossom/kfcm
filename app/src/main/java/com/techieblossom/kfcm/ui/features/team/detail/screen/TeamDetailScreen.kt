package com.techieblossom.kfcm.ui.features.team.detail.screen

import com.techieblossom.kfcm.ui.features.team.detail.composable.TeamTactics
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.techieblossom.kfcm.ui.features.team.detail.composable.TeamDetailAppBar
import com.techieblossom.kfcm.ui.features.team.detail.composable.TeamFormation
import com.techieblossom.kfcm.ui.features.team.detail.composable.TeamFormationInfo
import com.techieblossom.kfcm.ui.features.team.detail.composable.TeamOverview
import com.techieblossom.kfcm.ui.features.team.detail.composable.TeamSecondaryInfo
import com.techieblossom.kfcm.ui.features.team.detail.viewModel.TeamDetailScreenViewModel

val COLLAPSED_TOP_BAR_HEIGHT = 60.dp
val EXPANDED_TOP_BAR_HEIGHT = 120.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamDetailScreen(onBackPressed: () -> Boolean, onPlayerTapped: (playerId: Int) -> Unit) {
    val viewModel = viewModel<TeamDetailScreenViewModel>()
    val teamDetailsUiState = viewModel.teamUiState.collectAsState()
    val listState = rememberLazyListState()
    val isScrollingStarted by remember {
        derivedStateOf {
            listState.canScrollBackward
        }
    }

    val transition = updateTransition(targetState = isScrollingStarted, label = "")
    val boxSize by transition.animateDp(
        label = "",
        transitionSpec = { tween(durationMillis = 500) }) { isScrolling ->
        if (isScrolling) COLLAPSED_TOP_BAR_HEIGHT else EXPANDED_TOP_BAR_HEIGHT
    }

    Scaffold(
        contentWindowInsets = WindowInsets(left = 8.dp, right = 8.dp),
    ) { contentPadding ->
        Box {
            LazyColumn(
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxHeight(),
                state = listState,
            ) {
                item { Box(modifier = Modifier.padding(top = boxSize, bottom = 8.dp)) }

                item {
                    TeamOverview(
                        team = teamDetailsUiState.value.team,
                        modifier = Modifier
                            .padding(contentPadding)
                            .padding(bottom = 8.dp)
                    )
                }

//                item {
//                    TeamRecommendation(
//                        modifier = Modifier
//                            .padding(contentPadding)
//                            .padding(bottom = 8.dp)
//                    )
//                }

                item {
                    TeamFormationInfo(
                        teamDetailsUiState.value.formation,
                        teamDetailsUiState.value.team.details?.startingAverageAge,
                        modifier = Modifier
                            .padding(contentPadding)
                            .padding(bottom = 2.dp)
                    )
                }

                item {
                    teamDetailsUiState.value.team.starting?.let {
                        TeamFormation(
                            players = it,
                            formation = teamDetailsUiState.value.formation,
                            modifier = Modifier
                                .padding(contentPadding)
                                .padding(bottom = 8.dp),
                            onPlayerTapped = onPlayerTapped
                        )
                    }
                }

                item {
                    TeamTactics(
                        tactics = teamDetailsUiState.value.team.tactics,
                        modifier = Modifier
                            .padding(contentPadding)
                            .padding(bottom = 8.dp)
                    )
                }

                item {
                    TeamSecondaryInfo(
                        details = teamDetailsUiState.value.team.details,
                        modifier = Modifier
                            .padding(contentPadding)
                            .padding(bottom = 8.dp)
                    )
                }

            }
            TeamDetailAppBar(
                teamDetailsUiState.value.team,
                transition = transition,
                onBackPressed = onBackPressed
            )
        }
    }
}