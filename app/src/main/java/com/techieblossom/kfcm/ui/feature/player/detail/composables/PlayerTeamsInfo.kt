package com.techieblossom.kfcm.ui.feature.player.detail.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.techieblossom.kfcm.R
import com.techieblossom.kfcm.data.models.ActualPosition
import com.techieblossom.kfcm.data.models.LoanedFrom
import com.techieblossom.kfcm.data.models.Player
import com.techieblossom.kfcm.data.models.TeamMinimal
import com.techieblossom.kfcm.utility.domain.prepareTeamImageUrl
import com.techieblossom.kfcm.ui.previewMocks.playerForCard
import com.techieblossom.kfcm.ui.composable.Label
import com.techieblossom.kfcm.ui.composable.LabelValueHorizontal
import com.techieblossom.kfcm.utility.domain.dashIfNullOrBlank
import com.techieblossom.kfcm.ui.feature.team.list.composable.RatingStars
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun PlayerTeamsInfo(
    player: Player,
    clubTeamInfo: TeamMinimal?,
    nationalTeamInfo: TeamMinimal?,
    modifier: Modifier = Modifier,
) {
    Column(modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
//        Heading(stringResource(R.string.playsFor))
        clubTeamInfo?.let {
            TeamInfo(
                teamId = it.id,
                teamName = it.name,
                teamOverall = it.overall,
                jerseyNumber = player.clubJerseyNumber,
                position = player.clubPosition,
                contract = player.joinedOn + " - " + player.contractTill,
                loanedFrom = player.loanedFrom,
            )
        }
        nationalTeamInfo?.let {
            TeamInfo(
                teamId = it.id,
                teamName = it.name,
                teamOverall = it.overall,
                jerseyNumber = player.nationalTeamJerseyNumber,
                position = player.nationalTeamPosition,
                contract = null,
                loanedFrom = null,
            )
        }
    }
}

@Composable
private fun TeamInfo(
    modifier: Modifier = Modifier,
    teamId: Int?,
    teamOverall: Int?,
    teamName: String?,
    position: ActualPosition?,
    jerseyNumber: Int?,
    contract: String?,
    loanedFrom: LoanedFrom? = null,
) {
    Column(modifier = modifier) {
        teamId?.let {
            TeamImageLabel(
                teamId = it,
                teamName = teamName,
                teamOverall = teamOverall,
                iconSize = 40.dp
            )
        }
        position?.let {
            LabelValueHorizontal(label = "Position", value = it.name, applyColor = false)
        }
        jerseyNumber?.let {
            LabelValueHorizontal(
                label = "Kit number",
                value = it.toString(),
                applyColor = false
            )
        }
        contract?.let {
            LabelValueHorizontal(
                label = "Contract",
                value = it,
                applyColor = false
            )
        }
        loanedFrom?.let {
            if (loanedFrom.clubId != null) {
                Row {
                    Label(modifier = Modifier.weight(1f), label = "Loaned from")
                    TeamImageLabel(
                        teamId = it.clubId,
                        teamName = it.clubName,
                        iconSize = 20.dp,
                        teamTextStyle = MaterialTheme.typography.bodyMedium,
                    )
                }
            }
        }
    }
}

@Composable
fun TeamImageLabel(
    teamId: Int?,
    teamName: String?,
    teamOverall: Int? = null,
    iconSize: Dp,
    teamTextStyle: TextStyle? = null,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        teamId?.let {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(prepareTeamImageUrl(it))
                    .crossfade(true).build(),
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                modifier = Modifier
                    .size(iconSize),
                contentDescription = stringResource(id = R.string.team_logo),
            )
        }
        Column {
            teamName?.let {
                Text(
                    text = it.dashIfNullOrBlank(),
                    textAlign = TextAlign.End,
                    style = teamTextStyle ?: MaterialTheme.typography.titleMedium,
                )
            }
            teamOverall?.let {
                RatingStars(rating = it)
            }
        }
    }
}

@Preview
@Composable
fun Preview_PlayerContractDetails() {
    FCMTheme {
        Surface {
            PlayerTeamsInfo(
                player = playerForCard, clubTeamInfo = TeamMinimal(
                    1, name = "Real Madrid", overall = 84
                ), nationalTeamInfo = TeamMinimal(
                    1, name = "FC Barcelona", overall = 83
                ), modifier = Modifier
            )
        }
    }
}

@Preview
@Composable
fun Preview_TeamInfo() {
    FCMTheme {
        Surface {
            TeamInfo(
                Modifier,
                1,
                teamOverall = 83,
                "Manchester City",
                ActualPosition.CAM,
                30,
                "Aug 10, 2021 - 2023",
                null,
            )
        }
    }
}

@Preview
@Composable
fun Preview_TeamInfoWithLoaned() {
    FCMTheme {
        Surface {
            TeamInfo(
                Modifier,
                1,
                teamOverall = 84,
                "Manchester City",
                ActualPosition.CAM,
                30,
                "Aug 10, 2021 - 2023",
                LoanedFrom(1, "Arsenal"),
            )
        }
    }
}

@Preview
@Composable
fun Preview_TeamImageLabel() {
    FCMTheme {
        Surface {
            TeamImageLabel(
                teamId = 1,
                teamName = "Arsenal",
                teamOverall = 85,
                iconSize = 40.dp,
                teamTextStyle = MaterialTheme.typography.titleMedium,
            )
        }
    }
}