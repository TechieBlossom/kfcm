package com.techieblossom.kfcm.ui.features.team.detail.composable

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techieblossom.kfcm.data.models.Starting
import com.techieblossom.kfcm.previewMocks.teamForCard
import com.techieblossom.kfcm.ui.composable.Ground
import com.techieblossom.kfcm.ui.features.team.detail.model.Formation
import com.techieblossom.kfcm.ui.features.team.detail.usecase.getPositionOffsetMapping
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun TeamFormation(
    players: List<Starting>,
    modifier: Modifier = Modifier,
    formation: Formation?,
    onPlayerTapped: (playerId: Int) -> Unit,
) {
    BoxWithConstraints(modifier) {
        val itemWidth = 80.dp
        val width = maxWidth
        val length = maxWidth * 3 / 2
        val positionMap = getPositionOffsetMapping(width, length, formation)
        Ground(
            items = players.map { player ->
                positionMap[player.position]?.let {
                    PlayerItem(
                        itemWidth,
                        it,
                        player,
                        onPlayerTapped = onPlayerTapped,
                    )
                }
            }
        )
    }
}

@Preview
@Composable
fun Preview_TeamFormation() {
    FCMTheme {
        Surface {
            teamForCard.starting?.let {
                TeamFormation(
                    players = it,
                    modifier = Modifier.padding(8.dp),
                    formation = Formation.FourFiveOne,
                    onPlayerTapped = {}
                )
            }
        }
    }
}
