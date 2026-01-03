package com.theya.rustsdk

import java.io.InputStream
import java.io.OutputStream

class StreamAdapter(
    private val input: InputStream,
    private val output: OutputStream
) {
    fun write(data: ByteArray) {
        output.write(data)
        output.flush()
    }

    fun read(): ByteArray {
        val buffer = ByteArray(1024)
        val len = input.read(buffer)
        return if (len > 0) buffer.copyOf(len) else ByteArray(0)
    }
}
