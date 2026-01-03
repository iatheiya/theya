package com.theya.shellsetup

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SetupWizard(onComplete: () -> Unit) {
    Column {
        Text("Setup Wizard")
        Button(onClick = onComplete) {
            Text("Finish")
        }
    }
}
