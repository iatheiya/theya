package com.theya.usecases

import com.theya.api.SessionRepository
import javax.inject.Inject

class CloseSessionUseCase @Inject constructor(
    private val sessionRepository: SessionRepository
) {
    suspend operator fun invoke(sessionId: String) {
        sessionRepository.closeSession(sessionId)
    }
}
