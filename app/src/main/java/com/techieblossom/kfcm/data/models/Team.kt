package com.techieblossom.kfcm.data.models

import com.techieblossom.kfcm.constants.UIConstants
import com.techieblossom.kfcm.utility.domain.preparePlayerImageUrl
import com.techieblossom.kfcm.utility.domain.prepareTeamImageUrl

@kotlinx.serialization.Serializable
data class Team(
    val id: Int,
    val name: String? = null,
    val nationId: Int? = null,
    val leagueId: Int? = null,
    val overall: Int? = null,
    val attack: Int? = null,
    val midfield: Int? = null,
    val defence: Int? = null,
    val tactics: Tactics? = null,
    val kits: Int? = null,
    val details: Details? = null,
    val starting: List<Starting>? = null,
    val league: League? = null,
) {
    fun teamLogoURL() = prepareTeamImageUrl(id)

    fun teamLogoURLHD() = buildString {
        append(UIConstants.teamLogoPrefix)
        append(id)
        append("/240.png")
    }

    private fun hasTransferBudget() = details?.transferBudget?.isNotBlank() ?: false

    fun clubWorthAndTransferBudget() = buildString {
        append(details?.clubWorth ?: "")
        if (hasTransferBudget()) append(" | ${details?.transferBudget}")
    }

    fun kitsURL(): List<String> {
        val urls = mutableListOf<String>()
        repeat(if (isNation()) 3 else 4) { index ->
            urls.add(buildString {
                append(UIConstants.kitsImagePrefix)
                append(id)
                append("/23_")
                append(index)
                append("@3x.png")
            })
        }
        return urls
    }

    fun isNation(): Boolean = leagueId == 78
}

@kotlinx.serialization.Serializable
data class Tactics(
    val defence: Defence?,
    val offence: Offence?,
)

@kotlinx.serialization.Serializable
data class Defence(
    val defensiveStyle: String?,
    val teamWidth: Int?,
    val depth: Int?,
)

@kotlinx.serialization.Serializable
data class Offence(
    val buildUpPlay: String?,
    val chanceCreation: String?,
    val width: Int?,
    val playersInBox: Int?,
    val corners: Int?,
    val freeKicks: Int?,
)

@kotlinx.serialization.Serializable
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

@kotlinx.serialization.Serializable
data class Starting(
    val id: Int?,
    val name: String?,
    val position: ActualPosition?,
    val rating: Int?,
) {

    fun shortName(): String? {
        val indexOfEmptySpace = name?.indexOfFirst { it == ' ' }
        if (indexOfEmptySpace != -1) {
            return name?.substring(indexOfEmptySpace ?: 0)
        }
        return name
    }

    fun playerImageUrl() = preparePlayerImageUrl(id)
}