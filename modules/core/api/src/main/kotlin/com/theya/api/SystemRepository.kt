package com.theya.api

import kotlinx.coroutines.flow.Flow

interface SystemRepository {
    fun getCpuUsage(): Flow<Float>
    fun getRamUsage(): Flow<Long>
}
