package com.techieblossom.kfcm.data.models

import com.techieblossom.kfcm.constants.UIConstants

data class Team(
    val id: Int,
    val name: String?,
    val nationId: Int?,
    val leagueId: Int?,
    val overall: Int?,
    val attack: Int?,
    val midfield: Int?,
    val defence: Int?,
    val tactics: Tactics?,
    val kits: Int?,
    val details: Details?,
    val starting: List<Starting>?,
    val league: League?,
) {
    fun teamLogoURL() = buildString {
        append(UIConstants.teamLogoPrefix)
        append("/")
        append(id)
        append("/120.png")
    }

    private fun hasTransferBudget() = details?.transferBudget?.isNotBlank() ?: false

    fun clubWorthAndTransferBudget() = buildString {
        append(details?.clubWorth)
        if (hasTransferBudget()) append(" | ${details?.transferBudget}")
    }
}

data class Tactics(
    val defence: Defence?,
    val offence: Offence?,
)

data class Defence(
    val defensiveStyle: String?,
    val teamWidth: Int?,
    val depth: Int?
)

data class Offence(
    val buildUpPlay: String?,
    val chanceCreation: String?,
    val  width: Int?,
    val  playersInBox: Int?,
    val  corners: Int?,
    val  freeKicks: Int?,
)

data class Details(
    val homeStadium: String?,
    val rival: String?,
    val internationalPrestige: Int?,
    val domesticPrestige: Int?,
    val transferBudget: String?,
    val clubWorth: String?,
    val startingAverageAge: Double?,
    val teamAverageAge: Double?,
    val captain: String?,
    val shortFreeKick: String?,
    val longFreeKick: String?,
    val leftShortFreeKick: String?,
    val rightShortFreeKick: String?,
    val penalties: String?,
    val leftCorner: String?,
    val rightCorner: String?,
)

data class Starting(
    val id: Int?,
    val name: String?,
    val position: ActualPosition?,
    val rating: Int?,
)