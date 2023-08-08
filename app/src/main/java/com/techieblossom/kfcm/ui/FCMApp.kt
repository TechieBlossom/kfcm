package com.techieblossom.kfcm.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.techieblossom.kfcm.ui.features.player.detail.screen.PlayerDetailScreen
import com.techieblossom.kfcm.ui.features.team.detail.screen.TeamDetailScreen
import com.techieblossom.kfcm.ui.features.team.list.screen.TeamScreen

enum class FCMRoutes {
    Teams,
    TeamDetails,
    Leagues,
    Players,
    PlayerDetails
}

@Composable
fun FCMApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = FCMRoutes.Teams.name) {
        composable(FCMRoutes.Teams.name) {
            TeamScreen { teamId ->
                navController.navigate("${FCMRoutes.TeamDetails.name}/$teamId")
            }
        }
        composable("${FCMRoutes.TeamDetails.name}/{${RouteConstants.TEAM_ID}}") {
            TeamDetailScreen(
                onBackPressed = {
                    navController.popBackStack()
                },
                onPlayerTapped = { playerId ->
                    navController.navigate("${FCMRoutes.PlayerDetails.name}/$playerId")
                },
            )
        }
        composable("${FCMRoutes.PlayerDetails.name}/{${RouteConstants.PLAYER_ID}}") {
            PlayerDetailScreen()
        }
    }
}