package com.techieblossom.kfcm.data

import android.util.Log
import com.techieblossom.kfcm.data.models.Player
import com.techieblossom.kfcm.data.models.Team
import com.techieblossom.kfcm.data.models.TeamMinimal
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Order

suspend fun getTeams(page: Int, itemsPerPage: Long): List<Team> {
//    delay(2000)
    val start = page * itemsPerPage
    val end = ((page + 1) * itemsPerPage) - 1
    val client = supabaseConstants.getClient()
    val response =
        client.postgrest["table_team"].select(
            columns = "*, league: table_league(name, nation)"
        ) {
            range(start, end)
            order("overall", order = Order.DESCENDING)
            order("attack", order = Order.DESCENDING)
            order("midfield", order = Order.DESCENDING)
            order("defence", order = Order.DESCENDING)
        }
    val teams = response.decodeList<Team>()
    return teams
}

suspend fun getTeam(teamId: Int): Team {
    val client = supabaseConstants.getClient()
    val response =
        client.postgrest["table_team"].select(columns = "*, league: table_league(name, nation)") {
            eq("id", teamId)
        }
    val team = response.decodeSingle<Team>()
    Log.i("Team :", team.toString())
    return team
}

suspend fun getTeamMinimal(teamId: Int): TeamMinimal {
    val client = supabaseConstants.getClient()
    val response =
        client.postgrest["table_team"].select(columns = "id, name, overall") {
            eq("id", teamId)
        }
    val team = response.decodeSingle<TeamMinimal>()
    Log.i("Team minimal:", team.toString())
    return team
}

suspend fun getPlayer(playerId: Int): Player {
    val client = supabaseConstants.getClient()
    val response =
        client.postgrest["table_player"].select(columns = "*") {
            eq("id", playerId)
        }
    val player = response.decodeSingle<Player>()
    Log.i("Player :", player.toString())
    return player
}