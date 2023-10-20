package com.techieblossom.kfcm.ui.feature.team.list.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.techieblossom.kfcm.R
import com.techieblossom.kfcm.data.models.Team
import com.techieblossom.kfcm.ui.previewMocks.teamForCard
import com.techieblossom.kfcm.ui.composable.VerticalRating
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun TeamRating(team: Team, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        VerticalRating(label = stringResource(R.string.ovr), value = team.overall)
        VerticalRating(label = stringResource(R.string.att), value = team.attack)
        VerticalRating(label = stringResource(R.string.mid), value = team.midfield)
        VerticalRating(label = stringResource(R.string.def), value = team.defence)
    }
}

@Preview
@Composable
fun Preview_TeamRating() {
    FCMTheme {
        TeamRating(teamForCard)
    }
}


