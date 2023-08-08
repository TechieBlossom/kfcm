package com.techieblossom.kfcm.ui.features.team.detail.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.techieblossom.kfcm.R
import com.techieblossom.kfcm.data.models.Starting
import com.techieblossom.kfcm.previewMocks.teamForCard
import com.techieblossom.kfcm.ui.dashIfNullOrBlank
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun PlayerItem(
    itemWidth: Dp,
    dpOffset: DpOffset,
    player: Starting,
    modifier: Modifier = Modifier,
    onPlayerTapped: (playerId: Int) -> Unit,
) {
    Box(
        modifier = modifier
            .zIndex(1f)
            .width(itemWidth)
            .offset(
                dpOffset.x - itemWidth / 2, dpOffset.y - itemWidth,
            )
            .clickable {
                player.id?.let(onPlayerTapped)
            },
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(player.playerImageUrl())
                        .crossfade(true).build(),
                    placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.CenterHorizontally),
                    contentDescription = stringResource(R.string.player_image),
                )
            }
        }
        player.name?.let {
            Text(
                modifier = Modifier
                    .offset(0.dp, 50.dp)
                    .width(itemWidth),
                text = player.shortName()?.uppercase() ?: "-",
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.labelMedium,
                color = Color.White,
            )
        }
        Text(
            modifier = Modifier
                .offset(10.dp)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(horizontal = 2.dp),
            text = player.position?.name.dashIfNullOrBlank(),
            style = MaterialTheme.typography.labelMedium,
            color = Color.White,

            )
    }
}

@Preview
@Composable
fun Preview_PlayerItem() {
    FCMTheme {
        Box {
            PlayerItem(
                itemWidth = 80.dp,
                dpOffset = DpOffset(100.dp, 100.dp),
                player = teamForCard.starting?.first()!!,
                modifier = Modifier
            ) {}
        }
    }
}
