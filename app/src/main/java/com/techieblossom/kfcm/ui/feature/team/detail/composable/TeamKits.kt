package com.techieblossom.kfcm.ui.feature.team.detail.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.techieblossom.kfcm.R
import com.techieblossom.kfcm.ui.composable.Heading
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun TeamKits(kitsUrls: List<String>, isNation: Boolean, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        Heading(stringResource(R.string.kits))
        if (isNation) {
            Row {
                repeat(kitsUrls.size) {
                    Kit(url = kitsUrls[it], index = it)
                }
            }
        } else {
            Row {
                Kit(url = kitsUrls[0], index = 0)
                Kit(url = kitsUrls[1], index = 1)
            }
            Row {
                Kit(url = kitsUrls[2], index = 3)
                Kit(url = kitsUrls[3], index = 2)
            }
        }
    }
}

@Composable
fun RowScope.Kit(url: String, index: Int) {
    val bgColor =
        if (index.rem(2) == 1) MaterialTheme.colorScheme.surfaceVariant
        else MaterialTheme.colorScheme.inversePrimary
    Box(modifier = Modifier
        .weight(1f)
        .background(bgColor)) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(url)
                .crossfade(true).build(),
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            fallback = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = stringResource(id = R.string.kits_image),
            modifier = Modifier.align(Alignment.Center).padding(8.dp)
        )
    }
}


@Preview
@Composable
fun Preview_TeamKits_Nation() {
    FCMTheme {
        Surface {
            TeamKits(
                kitsUrls = listOf(
                    "1", "2", "3"
                ), isNation = true, modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun Preview_TeamKits() {
    FCMTheme {
        Surface {
            TeamKits(
                kitsUrls = listOf(
                    "1", "2", "3", "4"
                ), isNation = false, modifier = Modifier.padding(8.dp)
            )
        }
    }
}