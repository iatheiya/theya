package com.theya.terminal.util

class LogBuffer(private val capacity: Int = 1000) {
    private val lines = ArrayDeque<String>(capacity)

    fun add(line: String) {
        if (lines.size >= capacity) {
            lines.removeFirst()
        }
        lines.addLast(line)
    }

    fun getLines(): List<String> = lines.toList()
}
