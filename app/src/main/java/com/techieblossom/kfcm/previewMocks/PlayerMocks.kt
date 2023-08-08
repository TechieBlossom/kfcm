package com.techieblossom.kfcm.previewMocks

import com.techieblossom.kfcm.data.models.ActualPosition
import com.techieblossom.kfcm.data.models.Def
import com.techieblossom.kfcm.data.models.Dri
import com.techieblossom.kfcm.data.models.Gk
import com.techieblossom.kfcm.data.models.LoanedFrom
import com.techieblossom.kfcm.data.models.Pac
import com.techieblossom.kfcm.data.models.Pas
import com.techieblossom.kfcm.data.models.Phy
import com.techieblossom.kfcm.data.models.Player
import com.techieblossom.kfcm.data.models.PositionRatings
import com.techieblossom.kfcm.data.models.Sho

val playerForCard = Player(
    id = 158023,
    name = "Messi",
    fullName = "Lionel Andrés Messi Cuccittini",
    nationId = 1,
    nationName = "Argentina",
    nationFlag = "ar",
    positions = "[\"ST\", \"LW\", \"CAM\"]",
    bestPosition = ActualPosition.CAM,
    age = 35,
    dob = "Jun 24, 1987",
    weight = "67 kg | 148 lbs",
    height = "169 cm | 5'6\"",
    overall = "91",
    potential = "95",
    bestRating = 92,
    value = 54000000,
    wage = 195000,
    releaseClause = null,
    foot = "Left",
    weakFoot = 4,
    skillMoves = 4,
    internationalReputation = 5,
    workRate = "Low/Low",
    bodyType = "Unique",
    realFace = true,
    specialities = "[Dribbler, Engine, Acrobat, Clinical finisher, Complete forward]",
    clubId = 1,
    clubName = "Paris Saint-Germain",
    clubFlag = "psg",
    clubPosition = ActualPosition.RS,
    clubJerseyNumber = 30,
    joinedOn = "Aug 10, 2021",
    contractTill = "2023",
    isLoaned = true,
    loanedFrom = LoanedFrom(
        1, "Arsenal"
    ),
    nationalTeamId = 1,
    nationalTeamName = "Argentina",
    nationalTeamFlag = "ar",
    nationalTeamPosition = ActualPosition.RW,
    nationalTeamJerseyNumber = 10,
    positionRatings = PositionRatings(
        gk = "99",
        lb = "90",
        lcb = "85",
        cb = "80",
        rcb = "75",
        rb = "70",
        lwb = "65",
        ldm = "60",
        cdm = "55",
        rdm = "50",
        rwb = "45",
        lm = "40",
        lcm = "35",
        cm = "30",
        rcm = "25",
        rm = "20",
        lam = "15",
        cam = "10",
        ram = "05",
        lw = "10",
        lf = "25",
        cf = "35",
        rf = "45",
        rw = "55",
        ls = "65",
        st = "75",
        rs = "85",
    ),
    pac = Pac(
        sprintSpeed = "76",
        acceleration = "87"
    ),
    sho = Sho(
        finishing = "90",
        penalties = "75",
        longShots = "91",
        positioning = "93",
        shotPower = "86",
        volleys = "88"
    ),
    pas = Pas(
        vision = "94",
        crossing = "84",
        curve = "93",
        fkAccuracy = "93",
        longPassing = "90",
        shortPassing = "91"
    ),
    dri = Dri(
        agility = "91",
        balance = "95",
        ballControl = "93",
        composure = "96",
        dribbling = "95",
        reactions = "92"
    ),
    def = Def(
        interceptions = "40",
        defensiveAwareness = "20+2",
        headingAccuracy = "70",
        slidingTackle = "24",
        standingTackle = "35"
    ),
    phy = Phy(
        jumping = "68",
        stamina = "70",
        aggression = "44",
        strength = "68"
    ),
    gk = Gk(
        diving = "6",
        positioning = "14",
        handling = "11",
        kicking = "15",
        reflexes = "8"
    ),
    traits = "[Something]"
)