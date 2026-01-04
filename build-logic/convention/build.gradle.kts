plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    maven("https://plugins.gradle.org/m2/")
    google()
    mavenCentral()
    maven("https://jitpack.io")
}

group = "com.theya.buildlogic"

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.hilt.android.gradlePlugin)
    implementation("org.mozilla.rust-android-gradle:plugin:0.9.6")
}