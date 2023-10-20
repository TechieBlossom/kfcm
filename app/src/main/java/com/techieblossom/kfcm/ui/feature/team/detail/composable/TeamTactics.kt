package com.techieblossom.kfcm.ui.feature.team.detail.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techieblossom.kfcm.R
import com.techieblossom.kfcm.data.models.Tactics
import com.techieblossom.kfcm.ui.previewMocks.teamForCard
import com.techieblossom.kfcm.ui.composable.Heading
import com.techieblossom.kfcm.ui.composable.LabelValueHorizontal
import com.techieblossom.kfcm.utility.domain.dashIfNull
import com.techieblossom.kfcm.utility.domain.dashIfNullOrBlank
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun TeamTactics(tactics: Tactics?, modifier: Modifier) {
    Column(modifier = modifier) {
        Heading(stringResource(R.string.defence))
        LabelValueHorizontal(
            index = 0,
            label = stringResource(R.string.defensive_style),
            value = tactics?.defence?.defensiveStyle.dashIfNullOrBlank(),
        )
        LabelValueHorizontal(
            index = 1,
            label = stringResource(R.string.team_width),
            value = tactics?.defence?.teamWidth.dashIfNull()
        )
        LabelValueHorizontal(
            index = 2,
            label = stringResource(R.string.depth),
            value = tactics?.defence?.depth.dashIfNull()
        )
        Heading(stringResource(R.string.offence), modifier = Modifier.padding(top = 8.dp))
        LabelValueHorizontal(
            index = 0,
            label = stringResource(R.string.build_up_play),
            value = tactics?.offence?.buildUpPlay.dashIfNullOrBlank()
        )
        LabelValueHorizontal(
            index = 1,
            label = stringResource(R.string.chance_creation),
            value = tactics?.offence?.chanceCreation.dashIfNullOrBlank()
        )
        LabelValueHorizontal(
            index = 2,
            label = stringResource(R.string.width),
            value = tactics?.offence?.width.dashIfNull()
        )
        LabelValueHorizontal(
            index = 3,
            label = stringResource(R.string.players_in_box),
            value = tactics?.offence?.playersInBox.dashIfNull()
        )
        LabelValueHorizontal(
            index = 4,
            label = stringResource(R.string.corners),
            value = tactics?.offence?.corners.dashIfNull()
        )
        LabelValueHorizontal(
            index = 5,
            label = stringResource(R.string.free_kick),
            value = tactics?.offence?.freeKicks.dashIfNull()
        )
    }
}

@Preview
@Composable
fun Preview_TeamTactics() {
    FCMTheme {
        Surface {
            TeamTactics(tactics = teamForCard.tactics, modifier = Modifier.padding(8.dp))
        }
    }
}
