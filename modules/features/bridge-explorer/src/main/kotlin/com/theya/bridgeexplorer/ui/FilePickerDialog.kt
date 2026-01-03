package com.theya.bridgeexplorer.ui

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect

@Composable
fun FilePickerDialog(onUriResult: (android.net.Uri?) -> Unit) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument(),
        onResult = onUriResult
    )
    
    SideEffect {
        launcher.launch(arrayOf("*/*"))
    }
}
