package com.techieblossom.kfcm.data.models

import com.techieblossom.kfcm.constants.UIConstants
import com.techieblossom.kfcm.prepareAmountWithCurrency
import com.techieblossom.kfcm.preparePlayerImageUrl
import com.techieblossom.kfcm.prepareTeamImageUrl

@kotlinx.serialization.Serializable
data class Player(
    val id: Int,
    val name: String? = null,
    val fullName: String? = null,
    val nationId: Int? = null,
    val nationName: String? = null,
    val nationFlag: String? = null,
    val positions: String? = null,
    val bestPosition: ActualPosition? = null,
    val age: Int? = null,
    val dob: String? = null,
    val weight: String? = null,
    val height: String? = null,
    val overall: String? = null,
    val potential: String? = null,
    val bestRating: Int? = null,
    val value: Int? = null,
    val wage: Int? = null,
    val releaseClause: Int? = null,
    val foot: String? = null,
    val weakFoot: Int? = null,
    val skillMoves: Int? = null,
    val internationalReputation: Int? = null,
    val workRate: String? = null,
    val bodyType: String? = null,
    val realFace: Boolean? = null,
    val specialities: String? = null,
    val clubId: Int? = null,
    val clubName: String? = null,
    val clubFlag: String? = null,
    val clubPosition: ActualPosition? = null,
    val clubJerseyNumber: Int? = null,
    val joinedOn: String? = null,
    val contractTill: String? = null,
    val isLoaned: Boolean? = null,
    val loanedFrom: LoanedFrom? = null,
    val nationalTeamId: Int? = null,
    val nationalTeamName: String? = null,
    val nationalTeamFlag: String? = null,
    val nationalTeamPosition: ActualPosition? = null,
    val nationalTeamJerseyNumber: Int? = null,
    val positionRatings: PositionRatings? = null,
    val pac: Pac? = null,
    val sho: Sho? = null,
    val pas: Pas? = null,
    val dri: Dri? = null,
    val def: Def? = null,
    val phy: Phy? = null,
    val gk: Gk? = null,
    val traits: String? = null,
) {
    fun playerImageUrl() = preparePlayerImageUrl(id)

    fun teamLogoURL(customId: Int?) = prepareTeamImageUrl(customId ?: id)

    fun nationFlagImageUrl() = buildString {
        append(UIConstants.nationFlagImagePrefix)
        append("${nationFlag}.png")
    }

    fun printableValue() = prepareAmountWithCurrency(value)

    fun printableWage() = prepareAmountWithCurrency(wage)

    fun printReleaseClause() = prepareAmountWithCurrency(releaseClause)
}

@kotlinx.serialization.Serializable
data class LoanedFrom(
    val clubId: Int?,
    val clubName: String?,
)

@kotlinx.serialization.Serializable
data class PositionRatings(
    val gk: String?,
    val lb: String?,
    val lcb: String?,
    val cb: String?,
    val rcb: String?,
    val rb: String?,
    val lwb: String?,
    val ldm: String?,
    val cdm: String?,
    val rdm: String?,
    val rwb: String?,
    val lm: String?,
    val lcm: String?,
    val cm: String?,
    val rcm: String?,
    val rm: String?,
    val lam: String?,
    val cam: String?,
    val ram: String?,
    val lw: String?,
    val lf: String?,
    val cf: String?,
    val rf: String?,
    val rw: String?,
    val ls: String?,
    val st: String?,
    val rs: String?,
) {
    operator fun iterator() = listOf(
        ActualPosition.GK to gk,
        ActualPosition.LB to lb,
        ActualPosition.LCB to lcb,
        ActualPosition.CB to cb,
        ActualPosition.RCB to rcb,
        ActualPosition.RB to rb,
        ActualPosition.LWB to lwb,
        ActualPosition.LDM to ldm,
        ActualPosition.CDM to cdm,
        ActualPosition.RDM to rdm,
        ActualPosition.RWB to rwb,
        ActualPosition.LM to lm,
        ActualPosition.LCM to lcm,
        ActualPosition.CM to cm,
        ActualPosition.RCM to rcm,
        ActualPosition.RM to rm,
        ActualPosition.LAM to lam,
        ActualPosition.CAM to cam,
        ActualPosition.RAM to ram,
        ActualPosition.LW to lw,
        ActualPosition.LF to lf,
        ActualPosition.CF to cf,
        ActualPosition.RF to rf,
        ActualPosition.RW to rw,
        ActualPosition.LS to ls,
        ActualPosition.ST to st,
        ActualPosition.RS to rs,
    )
}

@kotlinx.serialization.Serializable
data class Pac(
    val sprintSpeed: String?,
    val acceleration: String?,
)

@kotlinx.serialization.Serializable
data class Sho(
    val volleys: String? = null,
    val finishing: String? = null,
    val longShots: String? = null,
    val penalties: String? = null,
    val shotPower: String? = null,
    val positioning: String? = null,
)

@kotlinx.serialization.Serializable
data class Pas(
    val curve: String? = null,
    val vision: String? = null,
    val crossing: String? = null,
    val fkAccuracy: String? = null,
    val longPassing: String? = null,
    val shortPassing: String? = null,
)

@kotlinx.serialization.Serializable
data class Dri(
    val agility: String? = null,
    val balance: String? = null,
    val composure: String? = null,
    val dribbling: String? = null,
    val reactions: String? = null,
    val ballControl: String? = null,
)

@kotlinx.serialization.Serializable
data class Def(
    val interceptions: String? = null,
    val slidingTackle: String? = null,
    val standingTackle: String? = null,
    val headingAccuracy: String? = null,
    val defensiveAwareness: String? = null,
)

@kotlinx.serialization.Serializable
data class Phy(
    val jumping: String? = null,
    val stamina: String? = null,
    val strength: String? = null,
    val aggression: String? = null,
)

@kotlinx.serialization.Serializable
data class Gk(
    val diving: String? = null,
    val kicking: String? = null,
    val handling: String? = null,
    val reflexes: String? = null,
    val positioning: String? = null,
)

data class PlayerBriefStats(
    val pac: Int,
    val sho: Int,
    val pas: Int,
    val dri: Int,
    val def: Int,
    val phy: Int,
)

data class PlayerBriefStatsGK(
    val div: Int,
    val han: Int,
    val kic: Int,
    val ref: Int,
    val spd: Int,
    val pos: Int,
)