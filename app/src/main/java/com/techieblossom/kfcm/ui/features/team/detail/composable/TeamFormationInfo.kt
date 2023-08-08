package com.techieblossom.kfcm.ui.features.team.detail.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.techieblossom.kfcm.R
import com.techieblossom.kfcm.ui.dashIfNullOrBlank
import com.techieblossom.kfcm.ui.features.team.detail.model.Formation
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun TeamFormationInfo(formation: Formation?, averageAge: Double?, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(stringResource(R.string.starting_xi), style = MaterialTheme.typography.labelMedium)
        Text(formation?.formationName.dashIfNullOrBlank(), style = MaterialTheme.typography.labelMedium)
        Text(
            stringResource(R.string.avg_age, averageAge.toString().dashIfNullOrBlank()),
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Preview
@Composable
fun Preview_TeamFormationInfo() {
    FCMTheme {
        TeamFormationInfo(formation = Formation.FourFiveOne, averageAge = 24.59)
    }
}