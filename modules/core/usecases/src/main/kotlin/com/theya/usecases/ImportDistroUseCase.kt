package com.theya.usecases

import com.theya.api.FileRepository
import javax.inject.Inject

class ImportDistroUseCase @Inject constructor(
    private val fileRepository: FileRepository
) {
    suspend operator fun invoke(uri: String): Result<Unit> {
        return fileRepository.importFile(uri)
    }
}
