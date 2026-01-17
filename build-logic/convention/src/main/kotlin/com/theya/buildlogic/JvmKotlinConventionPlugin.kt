package com.theya.buildlogic

import org.gradle.api.Plugin
import org.gradle.api.Project

class JvmKotlinConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("org.jetbrains.kotlin.jvm")
        }
    }
}
