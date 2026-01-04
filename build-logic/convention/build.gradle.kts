plugins {
    `kotlin-dsl`
}

group = "com.theya.buildlogic"

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.hilt.android.gradlePlugin)
}
