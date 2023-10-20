package com.techieblossom.kfcm.ui.previewMocks

import com.techieblossom.kfcm.data.models.ActualPosition
import com.techieblossom.kfcm.data.models.Defence
import com.techieblossom.kfcm.data.models.Details
import com.techieblossom.kfcm.data.models.League
import com.techieblossom.kfcm.data.models.Offence
import com.techieblossom.kfcm.data.models.Starting
import com.techieblossom.kfcm.data.models.Tactics
import com.techieblossom.kfcm.data.models.Team

val teamForCard = Team(
    id = 1,
    name = "FC Barcelona",
    overall = 85,
    attack = 83,
    midfield = 86,
    defence = 87,
    details = Details(
        homeStadium = "Spotify Camp Nou",
        captain = null,
        clubWorth = "€4.3B",
        transferBudget = null,
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
    starting = listOf(
        Starting(264240, "ter Stegen", ActualPosition.GK, rating = 90),
        Starting(264240, "Alex Balde", ActualPosition.LB, rating = 80),
        Starting(264240, "Christensen", ActualPosition.LCB, rating = 82),
        Starting(264240, "Araujo", ActualPosition.RCB, rating = 85),
        Starting(264240, "Kounde", ActualPosition.RB, rating = 83),
        Starting(264240, "Gavi", ActualPosition.LCM, rating = 85),
        Starting(264240, "De Jong", ActualPosition.CM, rating = 89),
        Starting(264240, "Pedri", ActualPosition.RCM, rating = 87),
        Starting(264240, "Dembele", ActualPosition.LW, rating = 86),
        Starting(264240, "Lewandowski", ActualPosition.ST, rating = 91),
        Starting(264240, "Raphinha", ActualPosition.RW, rating = 84),
    ),
    tactics = Tactics(
        defence = Defence(
            defensiveStyle = "Balanced",
            teamWidth = 61,
            depth = 81,
        ),
        offence = Offence(
            buildUpPlay = "Slow build up",
            chanceCreation = "Possession",
            width = 51,
            playersInBox = 7,
            corners = 3,
            freeKicks = 3,
        )
    )
)