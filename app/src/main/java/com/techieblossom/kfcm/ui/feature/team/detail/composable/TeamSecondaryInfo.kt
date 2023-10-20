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
import com.techieblossom.kfcm.data.models.Details
import com.techieblossom.kfcm.ui.previewMocks.teamForCard
import com.techieblossom.kfcm.ui.composable.Heading
import com.techieblossom.kfcm.ui.composable.LabelValueHorizontal
import com.techieblossom.kfcm.utility.domain.dashIfNull
import com.techieblossom.kfcm.utility.domain.dashIfNullOrBlank
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun TeamSecondaryInfo(details: Details?, modifier: Modifier) {
    Column(modifier = modifier) {
        Heading(stringResource(R.string.overview))
        LabelValueHorizontal(
            index = 0,
            label = stringResource(R.string.home_stadium),
            value = details?.homeStadium.dashIfNullOrBlank()
        )
        LabelValueHorizontal(
            index = 1,
            label = stringResource(R.string.rival_team),
            value = details?.rival.dashIfNullOrBlank()
        )
        LabelValueHorizontal(
            index = 2,
            label = stringResource(R.string.int_prestige),
            value = details?.internationalPrestige.dashIfNull()
        )
        LabelValueHorizontal(
            index = 3,
            label = stringResource(R.string.dom_prestige),
            value = details?.domesticPrestige.dashIfNull()
        )
    }
}

@Preview
@Composable
fun Preview_TeamSecondaryInfo() {
    FCMTheme {
        Surface {
            TeamSecondaryInfo(details = teamForCard.details, modifier = Modifier.padding(8.dp))
        }
    }
}
