plugins {
    id("com.android.library") version "8.2.2"
    id("org.jetbrains.kotlin.android") version "1.9.20"
    id("org.mozilla.rust-android-gradle.rust-android") version "0.9.3"
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
