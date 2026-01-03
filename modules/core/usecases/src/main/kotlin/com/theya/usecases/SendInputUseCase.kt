package com.theya.usecases

import com.theya.api.SessionRepository
import javax.inject.Inject

class SendInputUseCase @Inject constructor(
    private val sessionRepository: SessionRepository
) {
    suspend operator fun invoke(sessionId: String, input: String) {
        sessionRepository.sendCommand(sessionId, input)
    }
}
