package com.theya.terminal.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily

@Composable
fun LogViewer(buffer: List<String>) {
    LazyColumn {
        items(buffer) { line ->
            Text(
                text = line,
                color = Color.Green,
                fontFamily = FontFamily.Monospace
            )
        }
    }
}
