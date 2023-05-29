package com.techieblossom.kfcm.ui.features.teams

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.techieblossom.kfcm.constants.UIConstants
import com.techieblossom.kfcm.data.models.Team
import com.techieblossom.kfcm.previewMocks.teamForCard
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun TeamRating(team: Team, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        VerticalRating(label = UIConstants.ovr, value = team.overall)
        VerticalRating(label = UIConstants.att, value = team.attack)
        VerticalRating(label = UIConstants.mid, value = team.midfield)
        VerticalRating(label = UIConstants.def, value = team.defence)
    }
}

@Preview
@Composable
fun PreviewTeamRating() {
    FCMTheme {
        TeamRating(teamForCard)
    }
}


