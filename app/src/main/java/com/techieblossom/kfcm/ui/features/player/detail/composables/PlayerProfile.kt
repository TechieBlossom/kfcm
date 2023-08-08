package com.techieblossom.kfcm.ui.features.player.detail.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techieblossom.kfcm.R
import com.techieblossom.kfcm.data.models.Player
import com.techieblossom.kfcm.previewMocks.playerForCard
import com.techieblossom.kfcm.ui.capitalize
import com.techieblossom.kfcm.ui.composable.Heading
import com.techieblossom.kfcm.ui.dashIfNullOrBlank
import com.techieblossom.kfcm.ui.theme.FCMTheme
import java.util.Locale

@Composable
fun PlayerProfile(modifier: Modifier, player: Player) {
    Column(modifier = modifier) {
//        Heading(text = "PROFILE")
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Column {
                player.weakFoot?.let {
                    LabelStarValueHorizontal(it.toString(), "Weak foot")
                }
                player.weakFoot?.let {
                    LabelStarValueHorizontal(it.toString(), "Skill moves")
                }
                player.weakFoot?.let {
                    LabelStarValueHorizontal(it.toString(), "International reputation")
                }
            }
            Column(horizontalAlignment = Alignment.End) {
                player.workRate?.let {
                    ValueLabelHorizontal(it, "Work rate")
                }
                player.bodyType?.let {
                    ValueLabelHorizontal(it, "Body type")
                }
                player.realFace?.let {
                    ValueLabelHorizontal(
                        it.toString().capitalize().dashIfNullOrBlank(),
                        "Real face"
                    )
                }
            }
        }
    }
}

@Composable
private fun LabelStarValueHorizontal(label: String, value: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(label, style = MaterialTheme.typography.bodyMedium)
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.filled_star),
            contentDescription = "filled star",
            modifier = Modifier.padding(horizontal = 2.dp)
        )
        Box(modifier = Modifier.size(4.dp))
        Text(value, style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
private fun ValueLabelHorizontal(label: String, value: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(label, style = MaterialTheme.typography.bodyMedium)
        Box(modifier = Modifier.size(4.dp))
        Text(value, style = MaterialTheme.typography.bodySmall)
    }
}


@Preview
@Composable
fun Preview_PlayerProfile() {
    FCMTheme {
        Surface {
            PlayerProfile(modifier = Modifier.padding(8.dp), player = playerForCard)
        }
    }
}