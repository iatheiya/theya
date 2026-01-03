package com.theya.models

data class FileRef(
    val name: String,
    val path: String,
    val isDirectory: Boolean,
    val size: Long
)
