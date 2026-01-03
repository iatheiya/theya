package com.theya.api

import com.theya.models.Session
import kotlinx.coroutines.flow.Flow

interface SessionRepository {
    fun getActiveSessions(): Flow<List<Session>>
    suspend fun createSession(name: String): Session
    suspend fun closeSession(sessionId: String)
    suspend fun sendCommand(sessionId: String, command: String)
    suspend fun resize(sessionId: String, cols: Int, rows: Int)
}
