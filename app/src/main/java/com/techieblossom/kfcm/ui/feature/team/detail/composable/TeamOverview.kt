package com.techieblossom.kfcm.ui.feature.team.detail.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techieblossom.kfcm.R
import com.techieblossom.kfcm.data.models.Team
import com.techieblossom.kfcm.ui.previewMocks.teamForCard
import com.techieblossom.kfcm.ui.composable.LabelValueVertical
import com.techieblossom.kfcm.ui.composable.VerticalRating
import com.techieblossom.kfcm.utility.domain.dashIfNullOrBlank
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun TeamOverview(team: Team, modifier: Modifier = Modifier) {
    OutlinedCard(
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.outlineVariant),
        shape = RoundedCornerShape(4.dp),
        modifier = modifier
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            VerticalRating(label = stringResource(R.string.ovr), value = team.overall)
            VerticalRating(label = stringResource(R.string.att), value = team.attack)
            VerticalRating(label = stringResource(R.string.mid), value = team.midfield)
            VerticalRating(label = stringResource(R.string.def), value = team.defence)
            LabelValueVertical(
                label = stringResource(R.string.worth),
                value = team.details?.clubWorth.dashIfNullOrBlank()
            )
            LabelValueVertical(
                label = stringResource(R.string.budget),
                value = team.details?.transferBudget.dashIfNullOrBlank()
            )
        }
    }
}

@Preview
@Composable
fun Preview_TeamOverview() {
    FCMTheme {
        TeamOverview(team = teamForCard, Modifier.padding(8.dp))
    }
}