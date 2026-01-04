plugins {
    `kotlin-dsl`
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

group = "com.theya.buildlogic"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/kotlin/p/dev")
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.hilt.android.gradlePlugin)
    compileOnly(libs.rust.android.gradlePlugin)
}
