plugins {
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.kapt")
}

dependencies {
    "implementation"(libs.findLibrary("hilt.android").get())
    "kapt"(libs.findLibrary("hilt.compiler").get())
}
