plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.android.rust)
}

android {
    namespace = "com.theya.glue"
    compileSdk = 35
    ndkVersion = "26.1.10909125"

    defaultConfig {
        minSdk = 26
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
        }
    }
}

androidRust {
    module("theya_engine") {
        path = file("../engine-rs")
        profile = "release"
        targets = listOf("arm", "arm64", "x86", "x86_64")
    }
}

dependencies {
    implementation("net.java.dev.jna:jna:5.13.0")
}
