package com.theya.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.theya.dashboard.navigation.DashboardNav
import com.theya.dashboard.ui.DashboardScreen
import com.theya.terminal.ui.TerminalScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = DashboardNav.ROUTE) {
        composable(DashboardNav.ROUTE) {
            DashboardScreen(
                onSessionClick = { sessionId ->
                    navController.navigate("terminal/$sessionId")
                }
            )
        }
        
        composable("terminal/{sessionId}") { backStackEntry ->
            val sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
            TerminalScreen(
                sessionId = sessionId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
