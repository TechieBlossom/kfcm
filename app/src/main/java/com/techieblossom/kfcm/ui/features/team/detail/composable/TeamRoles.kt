package com.techieblossom.kfcm.ui.features.team.detail.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techieblossom.kfcm.R
import com.techieblossom.kfcm.data.models.Details
import com.techieblossom.kfcm.previewMocks.teamForCard
import com.techieblossom.kfcm.ui.composable.Heading
import com.techieblossom.kfcm.ui.composable.LabelValueHorizontal
import com.techieblossom.kfcm.ui.dashIfNullOrBlank
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun TeamRoles(details: Details?, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Heading(stringResource(R.string.roles))
        LabelValueHorizontal(
            index = 0,
            label = "CAPTAIN",
            value = details?.captain.dashIfNullOrBlank()
        )
        LabelValueHorizontal(
            index = 1,
            label = "PENALTIES",
            value = details?.captain.dashIfNullOrBlank()
        )
        LabelValueHorizontal(
            index = 2,
            label = "SHORT FREE KICK",
            value = details?.shortFreeKick.dashIfNullOrBlank()
        )
        LabelValueHorizontal(
            index = 3,
            label = "LEFT FREE KICK",
            value = details?.leftShortFreeKick.dashIfNullOrBlank()
        )
        LabelValueHorizontal(
            index = 4,
            label = "RIGHT FREE KICK",
            value = details?.rightShortFreeKick.dashIfNullOrBlank()
        )
        LabelValueHorizontal(
            index = 5,
            label = "LONG FREE KICK",
            value = details?.longFreeKick.dashIfNullOrBlank()
        )
        LabelValueHorizontal(
            index = 6,
            label = "LEFT CORNER",
            value = details?.leftCorner.dashIfNullOrBlank()
        )
        LabelValueHorizontal(
            index = 7,
            label = "RIGHT CORNER",
            value = details?.rightCorner.dashIfNullOrBlank()
        )
    }
}

@Preview
@Composable
fun Preview_TeamRoles() {
    FCMTheme {
        Surface {
            TeamRoles(details = teamForCard.details, modifier = Modifier.padding(8.dp))
        }
    }
}