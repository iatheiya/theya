plugins {
    `kotlin-dsl`
}

group = "com.theya.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.hilt.android.gradlePlugin)
    compileOnly(libs.rust.android.gradlePlugin)
}
