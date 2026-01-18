package com.theya.buildlogic

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val catalogsExt = extensions.findByType(VersionCatalogsExtension::class.java)
            val libsCatalog = try {
                catalogsExt?.named("libs")
            } catch (_: Exception) {
                null
            }

            val agpVersion = libsCatalog?.findVersion("agp")?.orElse(null)?.requiredVersion ?: "9.0.0"
            val kotlinVersion = libsCatalog?.findVersion("kotlin")?.orElse(null)?.requiredVersion ?: "2.3.0"
            val coreKtxVersion = libsCatalog?.findVersion("coreKtx")?.orElse(null)?.requiredVersion ?: "1.16.0"

            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                compileSdk = 35

                defaultConfig {
                    targetSdk = 35
                    minSdk = 24
                }

                buildTypes {
                    release {
                        isMinifyEnabled = true
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }
            }

            val deps = extensions.findByName("dependencies")
            if (deps != null) {
                val implementation = "implementation"
                val coreKtxCoord = "androidx.core:core-ktx:$coreKtxVersion"
                project.dependencies.add(implementation, coreKtxCoord)

                val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
                project.dependencies.add(implementation, kotlinStdlib)
            }
        }
    }
}