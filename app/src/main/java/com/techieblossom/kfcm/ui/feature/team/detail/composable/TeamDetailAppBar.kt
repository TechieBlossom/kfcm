package com.techieblossom.kfcm.ui.feature.team.detail.composable

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.techieblossom.kfcm.R
import com.techieblossom.kfcm.data.models.Team
import com.techieblossom.kfcm.ui.previewMocks.teamForCard
import com.techieblossom.kfcm.utility.domain.blankIfNullOrBlank
import com.techieblossom.kfcm.utility.domain.dashIfNullOrBlank
import com.techieblossom.kfcm.ui.feature.team.detail.screen.COLLAPSED_TOP_BAR_HEIGHT
import com.techieblossom.kfcm.ui.feature.team.detail.screen.EXPANDED_TOP_BAR_HEIGHT

@Composable
fun TeamDetailAppBar(
    team: Team,
    transition: Transition<Boolean>,
    onBackPressed: () -> Boolean
) {
    val boxSize by transition.animateDp(
        label = "",
        transitionSpec = { tween(durationMillis = 500) }) { isScrolling ->
        if (isScrolling) COLLAPSED_TOP_BAR_HEIGHT else EXPANDED_TOP_BAR_HEIGHT
    }
    val imageSize by transition.animateDp(
        label = "",
        transitionSpec = { tween(durationMillis = 500) }) { isScrolling ->
        if (isScrolling) 40.dp else 80.dp
    }
    val color: Color by transition.animateColor(label = "") { isScrolling ->
        if (isScrolling) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.9f) else MaterialTheme.colorScheme.primaryContainer
    }
    Box(
        modifier = Modifier
            .background(color)
            .fillMaxWidth()
            .height(boxSize),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            IconButton(
                onClick = { onBackPressed() },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = "")
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    team.name.dashIfNullOrBlank(),
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    team.league?.name.blankIfNullOrBlank()
                        .uppercase() + " (" + team.league?.nation.blankIfNullOrBlank()
                        .uppercase() + ")",
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(team.teamLogoURLHD())
                    .crossfade(true).build(),
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                modifier = Modifier
                    .size(imageSize)
                    .align(Alignment.CenterVertically),
                contentDescription = stringResource(id = R.string.team_logo),
            )
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@Preview
@Composable
fun Preview_TeamDetailAppBarExpanded() {
    TeamDetailAppBar(
        team = teamForCard,
        transition = updateTransition(targetState = false, label = ""),
        onBackPressed = { true }
    )
}

@Preview
@Composable
fun Preview_TeamDetailAppBarCollapsed() {
    TeamDetailAppBar(
        team = teamForCard,
        transition = updateTransition(targetState = true, label = ""),
        onBackPressed = { true }
    )
}