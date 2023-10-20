package com.techieblossom.kfcm.ui.feature.player.detail.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techieblossom.kfcm.data.models.Player
import com.techieblossom.kfcm.ui.previewMocks.playerForCard
import com.techieblossom.kfcm.ui.composable.Heading
import com.techieblossom.kfcm.utility.domain.dashIfNullOrBlank
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun PlayerSpecialitiesAndTraits(modifier: Modifier, player: Player) {
    val specialities = player.specialities?.removePrefix("[")?.removeSuffix("]")
    val traits = player.traits?.removePrefix("[")?.removeSuffix("]")
    Column(modifier) {
        player.specialities?.let {
            Heading(text = "SPECIALITIES & TRAITS", hasBgColor = true, textAlign = TextAlign.Center)
            Text(
                text = specialities.dashIfNullOrBlank(),
                style = MaterialTheme.typography.bodySmall
            )
        }
        if (traits?.isBlank() == false) {
            Text(
                text = traits,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }

}

@Preview
@Composable
fun Preview_PlayerSpecialitiesAndTraits() {
    FCMTheme {
        Surface {
            PlayerSpecialitiesAndTraits(modifier = Modifier.padding(8.dp), player = playerForCard)
        }
    }
}
