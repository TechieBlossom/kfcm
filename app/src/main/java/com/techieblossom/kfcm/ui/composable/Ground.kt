package com.techieblossom.kfcm.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techieblossom.kfcm.ui.previewMocks.teamForCard
import com.techieblossom.kfcm.ui.feature.team.detail.composable.PlayerItem
import com.techieblossom.kfcm.ui.feature.team.detail.usecase.getPositionOffsetMapping
import com.techieblossom.kfcm.ui.theme.FCMTheme
import com.techieblossom.kfcm.ui.theme.groundColor
import com.techieblossom.kfcm.ui.theme.groundMarkingColor
import com.techieblossom.kfcm.ui.theme.stripColor

@Composable
fun Ground(
    modifier: Modifier = Modifier,
    items: List<Unit?>? = null,
) {
    BoxWithConstraints(modifier) {
        val width = maxWidth
        val length = maxWidth * 3 / 2
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(4.dp))
                .border(
                    shape = RoundedCornerShape(4.dp),
                    width = 4.dp,
                    color = Color.Gray
                )
                .background(color = groundColor)
                .width(width)
                .height(length),
        ) {
            Box(
                modifier = Modifier
                    .absoluteOffset(width * 0.0f, 0.dp)
                    .background(stripColor)
                    .height(length)
                    .width(width * 0.2f)
            )
            Box(
                modifier = Modifier
                    .absoluteOffset(width * 0.4f, 0.dp)
                    .background(stripColor)
                    .height(length)
                    .width(width * 0.2f)
            )
            Box(
                modifier = Modifier
                    .absoluteOffset(width * 0.8f, 0.dp)
                    .background(stripColor)
                    .height(length)
                    .width(width * 0.2f)
            )
            Box(
                modifier = Modifier
                    .absoluteOffset(width * 0.28f, 0.dp)
                    .border(
                        shape = RoundedCornerShape(4.dp),
                        width = 4.dp,
                        color = groundMarkingColor
                    )
                    .width(width * 0.44f)
                    .height(length * 0.18f)
            )
            Box(
                modifier = Modifier
                    .absoluteOffset(width * 0.28f, length * 0.82f)
                    .border(
                        shape = RoundedCornerShape(4.dp),
                        width = 4.dp,
                        color = groundMarkingColor
                    )
                    .width(width * 0.44f)
                    .height(length * 0.18f)
            )
            Box(
                modifier = Modifier
                    .absoluteOffset(0.dp, length * 0.5f)
                    .border(
                        shape = RoundedCornerShape(4.dp),
                        width = 4.dp,
                        color = groundMarkingColor
                    )
                    .width(width)
                    .height(4.dp)
            )
            Box(
                modifier = Modifier
                    .absoluteOffset(
                        width * 0.5f - width * 0.125f,
                        length * 0.5f - width * 0.125f
                    )
                    .border(
                        shape = CircleShape,
                        width = 4.dp,
                        color = groundMarkingColor
                    )
                    .size(width * 0.25f)
            )
            {
                items?.map {
                    it
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview_Ground() {
    val positionMap = getPositionOffsetMapping(414.dp, 550.dp, null)
    FCMTheme {
        teamForCard.starting?.let {
            Ground(
                items = teamForCard.starting.map { player ->
                    positionMap[player.position]?.let {
                        PlayerItem(
                            80.dp,
                            it,
                            player,
                            modifier = Modifier,
                            onPlayerTapped = { },
                        )
                    }
                }
            )
        }
    }
}