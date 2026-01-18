package com.theya.buildlogic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.platform

class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val catalogs = extensions.findByType(VersionCatalogsExtension::class.java)
            val libs = try {
                catalogs?.named("libs")
            } catch (_: Exception) { null }

            val composeBomVersion = libs?.findVersion("composeBom")?.orElse(null)?.requiredVersion ?: "2025.12.01"

            val bomProvider = libs?.findLibrary("androidx-compose-bom")?.orElse(null)
            val uiProvider = libs?.findLibrary("androidx-compose-ui")?.orElse(null)
            val uiGraphicsProvider = libs?.findLibrary("androidx-ui-graphics")?.orElse(null)
            val uiToolingProvider = libs?.findLibrary("androidx-ui-tooling")?.orElse(null)
            val uiToolingPreviewProvider = libs?.findLibrary("androidx-ui-tooling-preview")?.orElse(null)
            val material3Provider = libs?.findLibrary("androidx-material3")?.orElse(null)

            val platformCoordinate = "androidx.compose:compose-bom:$composeBomVersion"

            val addImplementation: (Any) -> Unit = { dep -> project.dependencies.add("implementation", dep) }
            val addAndroidTest: (Any) -> Unit = { dep -> project.dependencies.add("androidTestImplementation", dep) }
            val addDebug: (Any) -> Unit = { dep -> project.dependencies.add("debugImplementation", dep) }

            val commonExt = extensions.getByType(CommonExtension::class.java)
            commonExt.apply {
                buildFeatures {
                    compose = true
                }
            }

            dependencies {
                val bomDep = bomProvider ?: project.dependencies.create(platformCoordinate)
                add("implementation", platform(bomDep))
                add("androidTestImplementation", platform(bomDep))

                val uiDep = uiProvider ?: project.dependencies.create("androidx.compose.ui:ui")
                val uiGraphicsDep = uiGraphicsProvider ?: project.dependencies.create("androidx.compose.ui:ui-graphics")
                val uiToolingPreviewDep = uiToolingPreviewProvider ?: project.dependencies.create("androidx.compose.ui:ui-tooling-preview")
                val material3Dep = material3Provider ?: project.dependencies.create("androidx.compose.material3:material3")
                val uiToolingDep = uiToolingProvider ?: project.dependencies.create("androidx.compose.ui:ui-tooling")

                add("implementation", uiDep)
                add("implementation", uiGraphicsDep)
                add("implementation", uiToolingPreviewDep)
                add("implementation", material3Dep)
                add("debugImplementation", uiToolingDep)
            }
        }
    }
}