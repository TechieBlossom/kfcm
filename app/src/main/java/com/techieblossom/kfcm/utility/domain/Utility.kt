package com.techieblossom.kfcm.utility.domain

import androidx.compose.ui.graphics.Color
import com.techieblossom.kfcm.constants.UIConstants
import com.techieblossom.kfcm.data.models.Player
import com.techieblossom.kfcm.data.models.PlayerBriefStats
import com.techieblossom.kfcm.data.models.PlayerBriefStatsGK
import com.techieblossom.kfcm.ui.theme.rating1
import com.techieblossom.kfcm.ui.theme.rating2
import com.techieblossom.kfcm.ui.theme.rating3
import com.techieblossom.kfcm.ui.theme.rating4
import com.techieblossom.kfcm.ui.theme.rating5

fun preparePlayerImageUrl(id: Int?): String {
    val idInString = id?.toString();
    val calculatedId = if (idInString?.length == 5) idInString.substring(
        0,
        3
    ) + "/" + idInString.substring(3, 5)
    else idInString?.substring(0, 3) + "/" + idInString?.substring(3, 6)
    return buildString {
        append(UIConstants.playerImagePrefix)
        append(calculatedId)
        append("/23_240.png")
    }
}

fun prepareTeamImageUrl(id: Int) = buildString {
    append(UIConstants.teamLogoPrefix)
    append(id)
    append("/120.png")
}

fun prepareAmountWithCurrency(value: Int?): String {
    if (value == null) return ""

    val suffix: String
    val k = value.div(1_000)
    val shortForm = if (k >= 1000) {
        val m = k.div(1_000)
        suffix = "M"
        m
    } else {
        suffix = "K"
        k
    }

    return buildString {
        append(UIConstants.euro)
        append(shortForm)
        append(suffix)
    }
}

fun prepareValueAndColorWithDelta(value: String?): Triple<Color, String?, String?> {
    if (value == null) {
        return Triple(calculateColor(null), null, null)
    }
    val plusIndex = value.indexOf("+")
    val minusIndex = value.indexOf("-")

    val color = when {
        plusIndex != -1 -> calculateColor(
            value.substring(0, plusIndex).toInt()
        )

        minusIndex != -1 -> calculateColor(
            value.substring(0, minusIndex).toInt()
        )

        else -> calculateColor(value.toInt())
    }

    if (plusIndex != -1 || minusIndex != -1) {
        val newValue = value.substring(0, value.length - 2)
        return Triple(color, newValue, value.substring(newValue.length, value.length))
    }

    return Triple(color, value, null)
}

fun calculateColor(value: Int?): Color {
    if (value == null) return rating1

    return when {
        value >= 81 -> rating5
        value >= 71 -> rating4
        value >= 61 -> rating3
        value >= 51 -> rating2
        else -> rating1
    }
}

fun calculatePlayerBriefStats(player: Player) = PlayerBriefStats(
    pac = player.pac?.acceleration.timesInt(0.45f).plus(player.pac?.sprintSpeed.timesInt(0.55f)),
    sho = player.sho?.finishing.timesInt(0.45f)
        .plus(player.sho?.longShots.timesInt(0.20f))
        .plus(player.sho?.penalties.timesInt(0.05f))
        .plus(player.sho?.positioning.timesInt(0.05f))
        .plus(player.sho?.shotPower.timesInt(0.20f))
        .plus(player.sho?.volleys.timesInt(0.05f)),
    pas = player.pas?.crossing.timesInt(0.20f)
        .plus(player.pas?.curve.timesInt(0.05f))
        .plus(player.pas?.fkAccuracy.timesInt(0.05f))
        .plus(player.pas?.longPassing.timesInt(0.15f))
        .plus(player.pas?.shortPassing.timesInt(0.35f))
        .plus(player.pas?.vision.timesInt(0.25f)),
    dri = player.dri?.agility.timesInt(0.1f)
        .plus(player.dri?.balance.timesInt(0.05f))
        .plus(player.dri?.ballControl.timesInt(0.35f))
        .plus(player.dri?.composure.timesInt(0.00f))
        .plus(player.dri?.dribbling.timesInt(0.50f))
        .plus(player.dri?.reactions.timesInt(0.00f)),
    def = player.def?.defensiveAwareness.timesInt(0.30f)
        .plus(player.def?.headingAccuracy.timesInt(0.10f))
        .plus(player.def?.interceptions.timesInt(0.20f))
        .plus(player.def?.slidingTackle.timesInt(0.10f))
        .plus(player.def?.standingTackle.timesInt(0.30f)),
    phy = player.phy?.aggression.timesInt(0.2f)
        .plus(player.phy?.jumping.timesInt(0.05f))
        .plus(player.phy?.stamina.timesInt(0.25f))
        .plus(player.phy?.strength.timesInt(0.5f)),
)

fun calculatePlayerBriefStatsGK(player: Player) = PlayerBriefStatsGK(
    div = player.gk?.diving.timesInt(1f),
    han = player.gk?.handling.timesInt(1f),
    kic = player.gk?.kicking.timesInt(1f),
    pos = player.gk?.positioning.timesInt(1f),
    ref = player.gk?.reflexes.timesInt(1f),
    spd = (player.pac?.acceleration.timesInt(1f)
        .plus(player.pac?.sprintSpeed.timesInt(1f)) / 2),
)