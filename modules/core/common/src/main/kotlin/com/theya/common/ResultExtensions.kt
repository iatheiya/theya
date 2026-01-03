package com.theya.common

inline fun <T> Result<T>.onSuccess(action: (T) -> Unit): Result<T> {
    if (isSuccess) action(getOrThrow())
    return this
}

inline fun <T> Result<T>.onFailure(action: (Throwable) -> Unit): Result<T> {
    exceptionOrNull()?.let(action)
    return this
}

fun <T> T.asSuccess(): Result<T> = Result.success(this)

fun <T> Throwable.asFailure(): Result<T> = Result.failure(this)
