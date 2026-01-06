plugins {
    `kotlin-dsl`
}

group = "com.theya.buildlogic"

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    maven("https://plugins.gradle.org/m2/")
}

dependencies {
    implementation("com.android.tools.build:gradle:8.7.3")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.21")
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.52")
    implementation("org.mozilla.rust-android-gradle:plugin:0.9.4")
}
