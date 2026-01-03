package com.theya.dashboard.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.theya.dashboard.viewmodel.DashboardViewModel

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel(),
    onSessionClick: (String) -> Unit
) {
    val sessions by viewModel.sessions.collectAsState()
    val metrics by viewModel.metrics.collectAsState()

    Scaffold(
        topBar = {
            Text(text = "CPU: ${metrics.cpuUsage}% RAM: ${metrics.ramUsage}MB")
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            LazyColumn {
                items(sessions) { session ->
                    DistroCard(
                        session = session,
                        onClick = { onSessionClick(session.id) }
                    )
                }
            }
        }
    }
}
