package com.techieblossom.kfcm.ui.feature.player.detail.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.techieblossom.kfcm.data.models.Player
import com.techieblossom.kfcm.utility.domain.prepareValueAndColorWithDelta
import com.techieblossom.kfcm.ui.previewMocks.playerForCard
import com.techieblossom.kfcm.ui.composable.Ground
import com.techieblossom.kfcm.ui.composable.Heading
import com.techieblossom.kfcm.ui.composable.VerticalRatingBox
import com.techieblossom.kfcm.ui.feature.team.detail.usecase.getPositionOffsetMapping
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun PlayerPositionRating(player: Player, modifier: Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Heading(text = "OVERALL RATING", hasBgColor =  true, textAlign = TextAlign.Center)
        BoxWithConstraints {
            val itemWidth = 50.dp
            val width = maxWidth
            val length = maxWidth * 3 / 2
            val positionMap = getPositionOffsetMapping(width, length, null)
            Ground(
                items = player.positionRatings?.iterator()?.map {
                    positionMap[it.first]?.let { offset ->
                        val triple = prepareValueAndColorWithDelta(it.second)
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .zIndex(1f)
                                .width(itemWidth)
                                .offset(
                                    offset.x - itemWidth / 2,
                                    offset.y - itemWidth
                                )
                                .background(triple.first),
                        ) {
                            VerticalRatingBox(
                                label = it.first.name,
                                value = triple.second + (triple.third ?: "")
                            )
                        }
                    }
                }
            )
        }
    }
}

@Composable
@Preview
fun Preview_PlayerPositionRating() {
    FCMTheme {
        Surface {
            PlayerPositionRating(
                player = playerForCard,
                modifier = Modifier
                    .padding(8.dp)
                    .width(414.dp)
                    .height((414 * 1.5).dp)
            )
        }
    }
}
