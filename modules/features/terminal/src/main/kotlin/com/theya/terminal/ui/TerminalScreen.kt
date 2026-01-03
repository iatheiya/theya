package com.theya.terminal.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.theya.terminal.viewmodel.TerminalViewModel

@Composable
fun TerminalScreen(
    sessionId: String,
    viewModel: TerminalViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    val buffer by viewModel.terminalBuffer.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            LogViewer(buffer = buffer)
        }
        ToolbarActions(
            modifier = Modifier.align(androidx.compose.ui.Alignment.BottomCenter),
            onEsc = { viewModel.sendInput("\u001B") },
            onTab = { viewModel.sendInput("\t") }
        )
    }
}
