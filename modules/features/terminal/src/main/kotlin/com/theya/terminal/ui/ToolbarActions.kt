package com.theya.terminal.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ToolbarActions(
    modifier: Modifier = Modifier,
    onEsc: () -> Unit,
    onTab: () -> Unit
) {
    Row(modifier = modifier) {
        Button(onClick = onEsc) { Text("ESC") }
        Button(onClick = onTab) { Text("TAB") }
    }
}
