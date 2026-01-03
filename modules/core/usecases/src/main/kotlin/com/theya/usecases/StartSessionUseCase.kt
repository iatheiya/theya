package com.theya.usecases

import com.theya.api.SessionRepository
import com.theya.models.Session
import javax.inject.Inject

class StartSessionUseCase @Inject constructor(
    private val sessionRepository: SessionRepository
) {
    suspend operator fun invoke(name: String): Result<Session> {
        return try {
            val session = sessionRepository.createSession(name)
            Result.success(session)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
