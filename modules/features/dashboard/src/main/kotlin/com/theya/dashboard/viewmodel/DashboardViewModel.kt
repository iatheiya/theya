package com.theya.dashboard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theya.api.SessionRepository
import com.theya.api.SystemRepository
import com.theya.models.Session
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

data class SystemMetrics(val cpuUsage: Float = 0f, val ramUsage: Long = 0)

@HiltViewModel
class DashboardViewModel @Inject constructor(
    sessionRepository: SessionRepository,
    systemRepository: SystemRepository
) : ViewModel() {

    val sessions: StateFlow<List<Session>> = sessionRepository.getActiveSessions()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val metrics: StateFlow<SystemMetrics> = combine(
        systemRepository.getCpuUsage(),
        systemRepository.getRamUsage()
    ) { cpu, ram -> SystemMetrics(cpu, ram) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), SystemMetrics())
}
