package com.theya.glue

object NativeBridge {
    init {
        System.loadLibrary("theya_engine")
    }

    external fun initEngine()
    external fun createSession(command: String): Int
    external fun writeToSession(pid: Int, data: ByteArray)
    external fun readFromSession(pid: Int): ByteArray
    external fun resizeSession(pid: Int, rows: Int, cols: Int)
}
