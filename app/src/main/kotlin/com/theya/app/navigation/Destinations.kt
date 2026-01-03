package com.theya.app.navigation

sealed class Screen(val route: String) {
    object Dashboard : Screen("dashboard")
    object Terminal : Screen("terminal/{sessionId}") {
        fun createRoute(sessionId: String) = "terminal/$sessionId"
    }
}
