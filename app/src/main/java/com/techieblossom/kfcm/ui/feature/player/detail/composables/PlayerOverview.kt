package com.techieblossom.kfcm.ui.feature.player.detail.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techieblossom.kfcm.R
import com.techieblossom.kfcm.data.models.Player
import com.techieblossom.kfcm.ui.previewMocks.playerForCard
import com.techieblossom.kfcm.ui.composable.LabelValueVertical
import com.techieblossom.kfcm.ui.composable.VerticalRating
import com.techieblossom.kfcm.utility.domain.dashIfNullOrBlank
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun PlayerOverview(player: Player, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
//        Heading(stringResource(R.string.overview))
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                VerticalRating(
                    label = stringResource(id = R.string.ovr),
                    value = player.overall
                )
                VerticalRating(
                    label = stringResource(id = R.string.pot),
                    value = player.potential
                )
                LabelValueVertical(
                    label = stringResource(id = R.string.value),
                    value = player.printableValue()
                )
                LabelValueVertical(
                    label = stringResource(id = R.string.wage),
                    value = player.printableWage()
                )
                LabelValueVertical(
                    label = stringResource(id = R.string.releaseClause),
                    value = player.printReleaseClause().dashIfNullOrBlank()
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Preview_PlayerOverview() {
    FCMTheme {
        Surface {
            PlayerOverview(player = playerForCard, modifier = Modifier.padding(8.dp))
        }
    }
}