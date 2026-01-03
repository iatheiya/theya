package com.theya.api

import com.theya.models.FileRef
import kotlinx.coroutines.flow.Flow

interface FileRepository {
    fun getFiles(path: String): Flow<List<FileRef>>
    suspend fun importFile(uri: String): Result<Unit>
}
