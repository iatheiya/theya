plugins {
    `kotlin-dsl`
}

group = "com.theya.buildlogic"

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation("com.android.tools.build:gradle:8.13.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.3.0")
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.57.2")
}

configurations.all {
    resolutionStrategy.eachDependency {
        if (requested.group == "org.jetbrains.kotlin") {
            useVersion("2.3.0")
        }
    }
}
