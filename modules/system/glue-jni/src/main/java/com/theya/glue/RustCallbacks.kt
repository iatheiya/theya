package com.theya.glue

interface RustCallbacks {
    fun onDataReceived(pid: Int, data: ByteArray)
    fun onSessionTerminated(pid: Int)
}
