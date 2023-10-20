package com.techieblossom.kfcm.ui.feature.player.detail.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.techieblossom.kfcm.R
import com.techieblossom.kfcm.data.models.Player
import com.techieblossom.kfcm.ui.previewMocks.playerForCard
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun PlayerBio(player: Player, modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(player.playerImageUrl())
                .crossfade(true).build(),
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            fallback = painterResource(id = R.drawable.ic_launcher_foreground),
            modifier = Modifier
                .size(90.dp)
                .align(Alignment.CenterVertically),
            contentDescription = stringResource(id = R.string.player_image),
        )
        Column(
            verticalArrangement = Arrangement.Center,

            modifier = Modifier
                .align(Alignment.CenterVertically)
        ) {
            player.name?.let {
                Text(
                    text = it.uppercase(),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                player.nationId?.let {
                    AsyncImage(
                        player.nationFlagImageUrl(),
                        placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                        fallback = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = "",
                        modifier = Modifier
                            .size(20.dp)
                            .padding(end = 8.dp),
                    )
                }
                player.nationName?.let {
                    Text(
                        text = it,
                        textAlign = TextAlign.Center,
                        maxLines = 2,
                        style = MaterialTheme.typography.bodySmall,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun Preview_PlayerBio() {
    FCMTheme {
        Surface {
            PlayerBio(player = playerForCard, modifier = Modifier.padding(8.dp))
        }
    }
}