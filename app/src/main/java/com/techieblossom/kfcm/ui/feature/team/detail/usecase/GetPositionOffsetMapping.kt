package com.techieblossom.kfcm.ui.feature.team.detail.usecase

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import com.techieblossom.kfcm.data.models.ActualPosition
import com.techieblossom.kfcm.ui.feature.team.detail.model.Formation

fun getPositionOffsetMapping(
    width: Dp,
    length: Dp,
    formation: Formation?,
): Map<ActualPosition, DpOffset> {
    return mapOf(
        ActualPosition.ST to DpOffset(width * 0.5f, length * 0.2f),
        ActualPosition.LS to DpOffset(width * 0.35f, length * 0.2f),
        ActualPosition.RS to DpOffset(width * 0.65f, length * 0.2f),
        ActualPosition.LW to DpOffset(width * 0.15f, length * 0.27f),
        ActualPosition.LF to DpOffset(width * 0.35f, length * 0.3f),
        ActualPosition.CF to DpOffset(width * 0.5f, length * 0.3f),
        ActualPosition.RF to DpOffset(width * 0.65f, length * 0.3f),
        ActualPosition.RW to DpOffset(width * 0.85f, length * 0.27f),
        ActualPosition.LAM to DpOffset(width * 0.25f, length * 0.4f),
        ActualPosition.CAM to DpOffset(width * 0.5f, length * 0.4f),
        ActualPosition.RAM to DpOffset(width * 0.75f, length * 0.4f),
        ActualPosition.LM to DpOffset(width * 0.12f, length * 0.4f),
        ActualPosition.LCM to if (isThreeOrFiveAtBackFormation(formation)) DpOffset(
            width * 0.3f,
            length * 0.55f
        ) else DpOffset(width * 0.25f, length * 0.55f),
        ActualPosition.CM to DpOffset(width * 0.5f, length * 0.48f),
        ActualPosition.RCM to if (isThreeOrFiveAtBackFormation(formation)) DpOffset(
            width * 0.7f,
            length * 0.55f
        ) else DpOffset(width * 0.75f, length * 0.55f),
        ActualPosition.RM to DpOffset(width * 0.88f, length * 0.4f),
        ActualPosition.LWB to DpOffset(width * 0.12f, length * 0.7f),
        ActualPosition.LDM to DpOffset(width * 0.3f, length * 0.63f),
        ActualPosition.CDM to DpOffset(width * 0.5f, length * 0.63f),
        ActualPosition.RDM to DpOffset(width * 0.7f, length * 0.63f),
        ActualPosition.RWB to DpOffset(width * 0.88f, length * 0.7f),
        ActualPosition.LB to DpOffset(width * 0.12f, length * 0.78f),
        ActualPosition.LCB to if (isThreeOrFiveAtBackFormation(formation)) DpOffset(
            width * 0.3f,
            length * 0.85f
        ) else DpOffset(width * 0.35f, length * 0.85f),
        ActualPosition.CB to DpOffset(width * 0.5f, length * 0.83f),
        ActualPosition.RCB to if (isThreeOrFiveAtBackFormation(formation)) DpOffset(
            width * 0.7f,
            length * 0.85f
        ) else DpOffset(width * 0.65f, length * 0.85f),
        ActualPosition.RB to DpOffset(width * 0.88f, length * 0.78f),
        ActualPosition.GK to DpOffset(width * 0.5f, length),
    )
}

private fun isThreeOrFiveAtBackFormation(formation: Formation?) = listOf(
    Formation.ThreeFourThree,
    Formation.ThreeFourOneTwo,
    Formation.ThreeFourTwoOne,
    Formation.ThreeFiveTwo,
    Formation.ThreeOneFourTwo,
    Formation.FiveTwoTwoOne,
    Formation.FiveFourOne,
    Formation.FiveOneTwoTwo,
    Formation.FiveTwoOneTwo,
).contains(formation)