package com.theya.buildlogic

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val catalogs = extensions.findByType(VersionCatalogsExtension::class.java)
            val libs = try {
                catalogs?.named("libs")
            } catch (_: Exception) { null }

            val hiltVersion = libs?.findVersion("hilt")?.orElse(null)?.requiredVersion ?: "2.58.0"

            val hiltAndroidProvider = libs?.findLibrary("hilt-android")?.orElse(null)
            val hiltCompilerProvider = libs?.findLibrary("hilt-compiler")?.orElse(null)

            with(pluginManager) {
                apply("com.google.dagger.hilt.android")
                apply("org.jetbrains.kotlin.kapt")
            }

            dependencies {
                val impl = hiltAndroidProvider ?: project.dependencies.create("com.google.dagger:hilt-android:$hiltVersion")
                val kaptDep = hiltCompilerProvider ?: project.dependencies.create("com.google.dagger:hilt-android-compiler:$hiltVersion")

                add("implementation", impl)
                add("kapt", kaptDep)
            }
        }
    }
}