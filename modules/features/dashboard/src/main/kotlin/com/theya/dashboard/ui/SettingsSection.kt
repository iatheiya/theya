package com.theya.dashboard.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SettingsSection(
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit
) {
    Column {
        Text("Settings")
        Switch(checked = isDarkTheme, onCheckedChange = onThemeChange)
    }
}
