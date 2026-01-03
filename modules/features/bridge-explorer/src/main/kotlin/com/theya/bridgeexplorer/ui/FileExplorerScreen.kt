package com.theya.bridgeexplorer.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun FileExplorerScreen(onFileSelected: (String) -> Unit) {
    Column {
        Text("Bridge Explorer")
        Button(onClick = { onFileSelected("file://test") }) {
            Text("Select File")
        }
    }
}
