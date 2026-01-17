plugins {
    `kotlin-dsl`
}

group = "com.theya.buildlogic"

dependencies {
    implementation("com.android.tools.build:gradle:8.13.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.3.0")
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.57.2")
}
