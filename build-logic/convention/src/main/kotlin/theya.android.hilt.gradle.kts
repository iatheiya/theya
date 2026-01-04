import com.theya.buildlogic.libs

plugins {
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.kapt")
}

dependencies {
    "implementation"(libs.hilt.android)
    "kapt"(libs.hilt.compiler)
}
