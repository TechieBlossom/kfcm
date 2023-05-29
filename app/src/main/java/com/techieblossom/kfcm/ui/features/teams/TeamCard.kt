package com.techieblossom.kfcm.ui.features.teams

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
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
import com.techieblossom.kfcm.data.models.Team
import com.techieblossom.kfcm.previewMocks.teamForCard
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun TeamCard(team: Team) {
    OutlinedCard(
        border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.outlineVariant),
        shape = RoundedCornerShape(8.dp),
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(team.teamLogoURL())
                .crossfade(true).build(),
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            modifier = Modifier
                .size(60.dp)
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally),
            contentDescription = stringResource(id = R.string.teamLogo),
        )
        team.name?.let {
            Text(
                text = it.uppercase(),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 4.dp)
            )
        }
        Text(
            text = team.clubWorthAndTransferBudget(),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        team.overall?.let {
            RatingStars(
                rating = it,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally),
            )
        }
        Divider(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp),
        )
        TeamRating(
            team = team,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 4.dp),
        )
        Divider(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp),
        )
        team.league?.name?.let {
            Text(
                text = it.uppercase(),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 8.dp, start = 8.dp, end = 8.dp)
            )
        }
    }
}

@Preview(
    device = "id:pixel_6a",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
)
@Composable
fun PreviewTeamCard() {
    FCMTheme {
        TeamCard(team = teamForCard)
    }
}