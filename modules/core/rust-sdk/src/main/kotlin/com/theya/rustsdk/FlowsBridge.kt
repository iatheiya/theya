package com.theya.rustsdk

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FlowsBridge @Inject constructor() {
    private val _outputFlow = MutableSharedFlow<Pair<Int, ByteArray>>(
        replay = 0,
        extraBufferCapacity = 64,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val outputFlow: SharedFlow<Pair<Int, ByteArray>> = _outputFlow

    fun emitOutput(pid: Int, data: ByteArray) {
        _outputFlow.tryEmit(pid to data)
    }
}
