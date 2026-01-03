package com.theya.models

data class Session(
    val id: String,
    val name: String,
    val currentPath: String = "~",
    val isActive: Boolean = true
)
