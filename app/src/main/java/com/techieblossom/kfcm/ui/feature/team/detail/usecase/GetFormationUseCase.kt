package com.techieblossom.kfcm.ui.feature.team.detail.usecase

import com.techieblossom.kfcm.data.models.ActualPosition
import com.techieblossom.kfcm.ui.feature.team.detail.model.Formation

fun getFormation(positions: List<ActualPosition?>?) = positions.let {
    when {
        it?.containsAll(
            listOf(
                ActualPosition.LWB,
                ActualPosition.RWB,
                ActualPosition.LCB,
                ActualPosition.CB,
                ActualPosition.RCB
            )
        ) ?: false-> handleFiveAtBackFormations(positions)

        it?.containsAll(
            listOf(
                ActualPosition.CB,
                ActualPosition.LCB,
                ActualPosition.RCB,
            )
        ) ?: false -> handleThreeAtBackFormations(positions)

        else -> handleFourAtBackFormations(positions)
    }
}

private fun handleFiveAtBackFormations(positions: List<ActualPosition?>?) = when {
    has1CAM(positions) -> Formation.FiveTwoOneTwo
    has1CDM(positions) -> Formation.FiveOneTwoTwo
    hasLM(positions) -> Formation.FiveFourOne
    else -> Formation.FiveTwoTwoOne
}

private fun handleThreeAtBackFormations(positions: List<ActualPosition?>?) = when {
    has1CDM(positions) -> Formation.ThreeOneFourTwo
    has2CDM(positions) -> Formation.ThreeFiveTwo
    has1CAM(positions) -> Formation.ThreeFourOneTwo
    hasLW(positions) -> Formation.ThreeFourThree
    else -> Formation.ThreeFourTwoOne
}

private fun handleFourAtBackFormations(positions: List<ActualPosition?>?) = when {
    hasLW(positions) -> when {
        hasCF(positions) -> Formation.FourThreeThreeVariant5
        has2ST(positions) -> Formation.FourTwoFour
        has1CAM(positions) -> Formation.FourThreeThreeVariant4
        has2CDM(positions) -> Formation.FourThreeThreeVariant3
        has1CDM(positions) -> Formation.FourThreeThreeVariant2
        else -> Formation.FourThreeThree
    }

    has2CF(positions) && hasST(positions) -> Formation.FourThreeTwoOne
    has2ST(positions) -> when {
        hasLM(positions) && has1CDM(positions) && has1CAM(positions) -> Formation.FourOneTwoOneTwo
        has2CM(positions) && has1CDM(positions) && has1CAM(positions) -> Formation.FourOneTwoOneTwoVariant2
        has2CDM(positions) && has2CAM(positions) -> Formation.FourTwoTwoTwo
        hasLM(positions) && has1CDM(positions) && has1CM(positions) -> Formation.FourOneThreeTwo
        has2CM(positions) && has1CAM(positions) -> Formation.FourThreeOneTwo
        hasLM(positions) && has2CM(positions) -> Formation.FourFourTwo
        else -> Formation.FourFourTwoVariant2
    }

    else -> when {
        has2CM(positions) && has1CDM(positions) -> Formation.FourOneFourOne
        has2CDM(positions) && has3CAM(positions) -> Formation.FourTwoThreeOne
        has2CDM(positions) && has1CAM(positions) -> Formation.FourTwoThreeOneVariant2
        has2CM(positions) && hasCF(positions) -> Formation.FourFourOneOne
        has2CM(positions) && has1CAM(positions) -> Formation.FourFourOneOneVariant2
        has1CM(positions) && has2CAM(positions) -> Formation.FourFiveOne
        else -> Formation.FourFiveOneVariant2
    }
}

private fun has1CDM(positions: List<ActualPosition?>?) = positions?.filter {
    it == ActualPosition.CDM
}?.size == 1

private fun has2CDM(positions: List<ActualPosition?>?) = positions?.filter {
    it == ActualPosition.LDM || it == ActualPosition.RDM
}?.size == 2

private fun has1CM(positions: List<ActualPosition?>?) = positions?.filter {
    it == ActualPosition.CM
}?.size == 1

private fun has2CM(positions: List<ActualPosition?>?) = positions?.filter {
    it == ActualPosition.LCM || it == ActualPosition.RCM
}?.size == 2

private fun has1CAM(positions: List<ActualPosition?>?) = positions?.filter {
    it == ActualPosition.CAM
}?.size == 1

private fun has2CAM(positions: List<ActualPosition?>?) = positions?.filter {
    it == ActualPosition.LAM || it == ActualPosition.RAM
}?.size == 2

private fun has3CAM(positions: List<ActualPosition?>?) = positions?.filter {
    it == ActualPosition.LAM || it == ActualPosition.CAM || it == ActualPosition.RAM
}?.size == 3

private fun hasLW(positions: List<ActualPosition?>?) = positions?.filter {
    it == ActualPosition.LW
}?.size == 1

private fun hasLM(positions: List<ActualPosition?>?) = positions?.filter {
    it == ActualPosition.LM
}?.size == 1

private fun hasCF(positions: List<ActualPosition?>?) = positions?.filter {
    it == ActualPosition.CF
}?.size == 1

private fun has2CF(positions: List<ActualPosition?>?) = positions?.filter {
    it == ActualPosition.LF || it == ActualPosition.RF
}?.size == 2

private fun hasST(positions: List<ActualPosition?>?) = positions?.filter {
    it == ActualPosition.ST
}?.size == 1

private fun has2ST(positions: List<ActualPosition?>?) = positions?.filter {
    it == ActualPosition.LS || it == ActualPosition.RS
}?.size == 2
