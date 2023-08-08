package com.techieblossom.kfcm.ui.features.player.detail.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.techieblossom.kfcm.data.models.TeamMinimal
import com.techieblossom.kfcm.previewMocks.playerForCard
import com.techieblossom.kfcm.ui.features.player.detail.composables.Hexagon
import com.techieblossom.kfcm.ui.features.player.detail.composables.PlayerBio
import com.techieblossom.kfcm.ui.features.player.detail.composables.PlayerOverview
import com.techieblossom.kfcm.ui.features.player.detail.composables.PlayerPositionRating
import com.techieblossom.kfcm.ui.features.player.detail.composables.PlayerProfile
import com.techieblossom.kfcm.ui.features.player.detail.composables.PlayerSpecialitiesAndTraits
import com.techieblossom.kfcm.ui.features.player.detail.composables.PlayerStats
import com.techieblossom.kfcm.ui.features.player.detail.composables.PlayerTeamsInfo
import com.techieblossom.kfcm.ui.features.player.detail.composables.StatsViewType
import com.techieblossom.kfcm.ui.features.player.detail.viewModel.PlayerDetailScreenViewModel
import com.techieblossom.kfcm.ui.theme.FCMTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerDetailScreen() {
    val viewModel = viewModel<PlayerDetailScreenViewModel>()
    val playerDetailUiState = viewModel.playerUiState.collectAsState()

    Scaffold(
        contentWindowInsets = WindowInsets(left = 8.dp, right = 8.dp),
    ) { contentPadding ->
        Box(
            modifier = Modifier
                .padding(contentPadding)
        ) {
            playerDetailUiState.value.player.let { player ->
                PlayerBio(player)
            }
        }
        playerDetailUiState.value.player.let { player ->
            LazyColumn(modifier = Modifier.padding(top = 130.dp)) {
                item {
                    val modifier = Modifier
                        .padding(contentPadding)
                        .padding(bottom = 8.dp)
                    PlayerOverview(
                        player, modifier = modifier
                    )
                    PlayerProfile(
                        modifier = modifier,
                        player = player,
                    )
                    PlayerTeamsInfo(
                        player = player,
                        clubTeamInfo = playerDetailUiState.value.clubTeamInfo,
                        nationalTeamInfo = playerDetailUiState.value.nationalTeamInfo,
                        modifier = modifier
                    )
                    PlayerStats(
                        modifier = modifier,
                        player = player,
                        statsViewType = StatsViewType.Fut,
                    )
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Hexagon(
                            modifier = modifier
                                .padding(8.dp)
                                .width(180.dp)
                                .height(180.dp),
                            player = player,
                            labelSize = 10.sp,
                        )
                    }
                    PlayerSpecialitiesAndTraits(
                        modifier = modifier,
                        player = player,
                    )
                    PlayerPositionRating(
                        modifier = modifier,
                        player = player,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview_Details() {
    FCMTheme {
        Surface(modifier = Modifier.height(2000.dp)) {
            LazyColumn {
                item { PlayerBio(playerForCard) }
                val modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(top = 8.dp)
                item {
                    PlayerOverview(
                        player = playerForCard, modifier = modifier.padding(top = 8.dp),
                    )
                    PlayerProfile(
                        modifier = modifier.padding(top = 8.dp),
                        player = playerForCard,
                    )
                    PlayerTeamsInfo(
                        player = playerForCard,
                        clubTeamInfo = TeamMinimal(
                            playerForCard.clubId!!,
                            playerForCard.clubName,
                            87
                        ),
                        nationalTeamInfo = TeamMinimal(
                            playerForCard.nationalTeamId!!,
                            playerForCard.nationalTeamName,
                            83
                        ),
                        modifier = modifier.padding(top = 8.dp)
                    )
                    PlayerStats(
                        modifier = modifier.padding(top = 8.dp),
                        player = playerForCard,
                        statsViewType = StatsViewType.Fut,
                    )
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Hexagon(
                            modifier = modifier.align(Alignment.Center)
                                .padding(8.dp)
                                .width(200.dp)
                                .height(200.dp),
                            player = playerForCard,
                            labelSize = 10.sp,
                        )
                    }
                    PlayerSpecialitiesAndTraits(
                        modifier = modifier.padding(top = 8.dp),
                        player = playerForCard,
                    )
                    PlayerPositionRating(
                        modifier = modifier.padding(top = 8.dp),
                        player = playerForCard,
                    )
                }
            }
        }
    }
}