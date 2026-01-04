plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.mozilla.rust-android-gradle.rust-android") version "0.9.6"
}

android {
    namespace = "com.theya.glue"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
        consumerProguardFiles("consumer-rules.pro")
    }
}

cargo {
    module = "../engine-rs"
    libname = "theya_engine"
    targets = listOf("arm", "arm64", "x86", "x86_64")
    profile = "release"
}

dependencies {
    implementation("net.java.dev.jna:jna:5.13.0")
}
