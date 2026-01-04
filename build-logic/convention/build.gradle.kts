
plugins {
    `kotlin-dsl`
}

group = "com.theya.buildlogic"

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    maven("https://plugins.gradle.org/m2/")
    maven("https://maven.pkg.jetbrains.space/public/p/kotlin/p/dev")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.hilt.android.gradlePlugin)
    implementation(libs.rust.android.gradlePlugin)
}
