package com.theya.models

sealed class AppError : Exception() {
    data class IoError(override val message: String) : AppError()
    data class SessionError(override val message: String) : AppError()
    object UnknownError : AppError()
}
