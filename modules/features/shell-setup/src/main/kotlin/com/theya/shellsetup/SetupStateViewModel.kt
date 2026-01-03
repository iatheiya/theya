package com.theya.shellsetup

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SetupStateViewModel @Inject constructor() : ViewModel() {
    var isComplete: Boolean = false
}
