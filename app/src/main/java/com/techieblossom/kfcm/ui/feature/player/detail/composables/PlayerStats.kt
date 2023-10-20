package com.techieblossom.kfcm.ui.feature.player.detail.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techieblossom.kfcm.data.models.ActualPosition
import com.techieblossom.kfcm.data.models.Player
import com.techieblossom.kfcm.ui.previewMocks.playerForCard
import com.techieblossom.kfcm.ui.composable.Heading
import com.techieblossom.kfcm.ui.composable.RatingValue
import com.techieblossom.kfcm.ui.composable.SubHeading
import com.techieblossom.kfcm.ui.composable.VerticalRating
import com.techieblossom.kfcm.utility.domain.dashIfNullOrBlank
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun PlayerStats(modifier: Modifier, player: Player, statsViewType: StatsViewType) {
    if (player.bestPosition == ActualPosition.GK) {
        Column(modifier = modifier) {
            Heading(
                text = "STATS",
                textAlign = TextAlign.Center,
                hasBgColor = true,
            )
            Heading(text = "GOALKEEPING")
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                VerticalRating(label = "Diving", value = player.gk?.diving.dashIfNullOrBlank())
                VerticalRating(label = "Handling", value = player.gk?.handling.dashIfNullOrBlank())
                VerticalRating(label = "Kicking", value = player.gk?.kicking.dashIfNullOrBlank())
                VerticalRating(
                    label = "Positioning",
                    value = player.gk?.positioning.dashIfNullOrBlank()
                )
                VerticalRating(label = "Reflexes", value = player.gk?.reflexes.dashIfNullOrBlank())
            }
        }
    } else {
        player.name?.let {
            val stats = getStatsList(statsViewType, player)
            Column(modifier = modifier) {
                Heading(
                    text = "STATS",
                    textAlign = TextAlign.Start,
                    hasBgColor = true,
                )
                PlayerStats(stats)
            }
        }
    }
}

@Composable
private fun PlayerStats(stats: List<Map<String, List<Pair<String, String?>>>>) {
    stats.forEach { list ->
        Row(
            modifier = Modifier.padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            list.entries.map {
                Column(modifier = Modifier.weight(1f).padding(top = 4.dp)) {
                    SubHeading(text = it.key)
                    it.value.map { stat ->
                        StatsHorizontal(
                            label = stat.first,
                            value = stat.second.dashIfNullOrBlank()
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StatsHorizontal(label: String, value: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 2.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        RatingValue(value = value)
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

private fun getStatsList(statsViewType: StatsViewType, player: Player) =
    when (statsViewType) {
        StatsViewType.Fut -> prepareStatsListForFut(player)
        StatsViewType.Career -> prepareStatsListForCareer(player)
        StatsViewType.Classic -> prepareStatsListForClassic(player)
    }

private fun prepareStatsListForFut(player: Player) = listOf(
    mapOf(
        "PACE" to listOf(
            Pair("Sprint speed", player.pac?.sprintSpeed),
            Pair("Acceleration", player.pac?.acceleration)
        ),
        "SHOOT" to listOf(
            Pair("Finishing", player.sho?.finishing),
            Pair("Positioning", player.sho?.positioning),
            Pair("Long shots", player.sho?.longShots),
            Pair("Shot power", player.sho?.shotPower),
            Pair("Penalties", player.sho?.penalties),
            Pair("Volleys", player.sho?.volleys),
        ),
        "PASS" to listOf(
            Pair("Vision", player.pas?.vision),
            Pair("Crossing", player.pas?.crossing),
            Pair("FK accuracy", player.pas?.fkAccuracy),
            Pair("Long passing", player.pas?.longPassing),
            Pair("Short passing", player.pas?.shortPassing),
            Pair("Curve", player.pas?.curve),
        ),
    ),
    mapOf(
        "DRIBBLE" to listOf(
            Pair("Agility", player.dri?.agility),
            Pair("Balance", player.dri?.balance),
            Pair("Reactions", player.dri?.reactions),
            Pair("Composure", player.dri?.composure),
            Pair("Ball control", player.dri?.ballControl),
            Pair("Dribbling", player.dri?.dribbling),
        ),
        "DEFENCE" to listOf(
            Pair("Interceptions", player.def?.interceptions),
            Pair("Head. accuracy", player.def?.headingAccuracy),
            Pair("Def. awareness", player.def?.defensiveAwareness),
            Pair("Standing tackle", player.def?.standingTackle),
            Pair("Sliding tackle", player.def?.slidingTackle),
        ),
        "PHYSICAL" to listOf(
            Pair("Jumping", player.phy?.jumping),
            Pair("Stamina", player.phy?.stamina),
            Pair("Strength", player.phy?.strength),
            Pair("Aggression", player.phy?.aggression),
        ),
    )
)

private fun prepareStatsListForClassic(player: Player) = listOf(
    mapOf(
        "ATTACKING" to listOf(
            Pair("Crossing", player.pas?.crossing),
            Pair("Finishing", player.sho?.finishing),
            Pair("Head. accuracy", player.def?.headingAccuracy),
            Pair("Short passing", player.pas?.shortPassing),
            Pair("Volleys", player.sho?.volleys),
        ),
        "SKILL" to listOf(
            Pair("Dribbling", player.dri?.dribbling),
            Pair("Curve", player.pas?.curve),
            Pair("FK accuracy", player.pas?.fkAccuracy),
            Pair("Long passing", player.pas?.longPassing),
            Pair("Ball control", player.dri?.ballControl),
        ),
        "MOVEMENT" to listOf(
            Pair("Acceleration", player.pac?.acceleration),
            Pair("Sprint speed", player.pac?.sprintSpeed),
            Pair("Agility", player.dri?.agility),
            Pair("Reactions", player.dri?.reactions),
            Pair("Balance", player.dri?.balance),
        ),
    ),
    mapOf(
        "POWER" to listOf(
            Pair("Shot power", player.sho?.shotPower),
            Pair("Jumping", player.phy?.jumping),
            Pair("Stamina", player.phy?.stamina),
            Pair("Strength", player.phy?.strength),
            Pair("Long shots", player.sho?.longShots),
        ),
        "MENTALITY" to listOf(
            Pair("Aggression", player.phy?.aggression),
            Pair("Interceptions", player.def?.interceptions),
            Pair("Positioning", player.sho?.positioning),
            Pair("Vision", player.pas?.vision),
            Pair("Penalties", player.sho?.penalties),
            Pair("Composure", player.dri?.composure),
        ),
        "DEFENDING" to listOf(
            Pair("Def. awareness", player.def?.defensiveAwareness),
            Pair("Standing tackle", player.def?.standingTackle),
            Pair("Sliding tackle", player.def?.slidingTackle),
        ),
    )
)

private fun prepareStatsListForCareer(player: Player) = listOf(
    mapOf(
        "PHYSICAL" to listOf(
            Pair("Acceleration", player.pac?.acceleration),
            Pair("Agility", player.dri?.agility),
            Pair("Balance", player.dri?.balance),
            Pair("Jumping", player.phy?.jumping),
            Pair("Reactions", player.dri?.reactions),
            Pair("Sprint speed", player.pac?.sprintSpeed),
            Pair("Stamina", player.phy?.stamina),
            Pair("Strength", player.phy?.strength),
        ),
        "MENTAL" to listOf(
            Pair("Aggression", player.phy?.aggression),
            Pair("Positioning", player.sho?.positioning),
            Pair("Composure", player.dri?.composure),
            Pair("Interceptions", player.def?.interceptions),
            Pair("Vision", player.pas?.vision),
        ),
        "TECHNICAL" to listOf(
            Pair("Ball control", player.dri?.ballControl),
            Pair("Crossing", player.pas?.crossing),
            Pair("Curve", player.pas?.curve),
            Pair("Def. awareness", player.def?.defensiveAwareness),
            Pair("Dribbling", player.dri?.dribbling),
            Pair("FK accuracy", player.pas?.fkAccuracy),
            Pair("Finishing", player.sho?.finishing),
            Pair("Head. accuracy", player.def?.headingAccuracy),
            Pair("Long passing", player.pas?.longPassing),
            Pair("Long shots", player.sho?.longShots),
            Pair("Penalties", player.sho?.penalties),
            Pair("Short passing", player.pas?.shortPassing),
            Pair("Shot power", player.sho?.shotPower),
            Pair("Sliding tackle", player.def?.slidingTackle),
            Pair("Standing tackle", player.def?.standingTackle),
            Pair("Volleys", player.sho?.volleys),
        ),
    ),
)

enum class StatsViewType {
    Classic,
    Career,
    Fut,
}

@Preview
@Composable
fun Preview_StatsHorizontal() {
    FCMTheme {
        Surface {
            StatsHorizontal(label = "Sprint speed", value = "90")
        }
    }
}

@Preview
@Composable
fun Preview_PlayerStatsFut() {
    FCMTheme {
        Surface {
            PlayerStats(
                modifier = Modifier.padding(8.dp),
                player = playerForCard,
                statsViewType = StatsViewType.Fut,
            )
        }
    }
}

@Preview
@Composable
fun Preview_PlayerStatsCareer() {
    FCMTheme {
        Surface {
            PlayerStats(
                modifier = Modifier.padding(8.dp),
                player = playerForCard,
                statsViewType = StatsViewType.Career,
            )
        }
    }
}

@Preview
@Composable
fun Preview_PlayerStatsClassic() {
    FCMTheme {
        Surface {
            PlayerStats(
                modifier = Modifier.padding(8.dp),
                player = playerForCard,
                statsViewType = StatsViewType.Classic,
            )
        }
    }
}