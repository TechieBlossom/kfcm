package com.techieblossom.kfcm.previewMocks

import com.techieblossom.kfcm.data.models.Details
import com.techieblossom.kfcm.data.models.League
import com.techieblossom.kfcm.data.models.Team

val teamForCard = Team(
    id = 1,
    name = "FC Barcelona",
    overall = 85,
    attack = 83,
    midfield = 86,
    defence = 87,
    details = Details(
        homeStadium = null,
        captain = null,
        clubWorth = "€4.3B",
        transferBudget = "€20M",
        internationalPrestige = 10,
        domesticPrestige = 10,
        leftCorner = null,
        rightCorner = null,
        longFreeKick = null,
        penalties = null,
        leftShortFreeKick = null,
        rightShortFreeKick = null,
        shortFreeKick = null,
        rival = "Real madrid",
        teamAverageAge = 24.54,
        startingAverageAge = 26.80
    ),
    kits = 4,
    league = League(name = "La Liga", nation = "Spain"),
    leagueId = 1,
    nationId = 1,
    starting = null,
    tactics = null
)