package com.theya.terminal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theya.usecases.SendInputUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TerminalViewModel @Inject constructor(
    private val sendInputUseCase: SendInputUseCase
) : ViewModel() {

    private val _terminalBuffer = MutableStateFlow<List<String>>(listOf("Welcome to Theya Shell"))
    val terminalBuffer: StateFlow<List<String>> = _terminalBuffer

    fun sendInput(input: String) {
        viewModelScope.launch {
            _terminalBuffer.value = _terminalBuffer.value + input
        }
    }
}
