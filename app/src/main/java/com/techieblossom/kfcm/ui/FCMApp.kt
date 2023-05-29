package com.techieblossom.kfcm.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.techieblossom.kfcm.ui.features.teams.TeamScreen

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
            TeamScreen()
        }
    }
}