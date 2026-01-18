plugins {
    id("org.jetbrains.kotlin.jvm") version "2.3.0"
    id("java-gradle-plugin")
}

group = "com.theya.buildlogic"

kotlin {
    jvmToolchain(21)
}

dependencies {
    compileOnly(gradleApi())
    compileOnly("com.android.tools.build:gradle:9.0.0")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:2.3.0")
    compileOnly("com.google.dagger:hilt-android-gradle-plugin:2.58.0")
    compileOnly("org.jetbrains.kotlin:compose-compiler-gradle-plugin:2.3.0")
}

gradlePlugin {
    plugins {
        create("androidApplication") {
            id = "theya.android.application"
            implementationClass = "com.theya.buildlogic.AndroidApplicationConventionPlugin"
        }
        create("androidLibrary") {
            id = "theya.android.library"
            implementationClass = "com.theya.buildlogic.AndroidLibraryConventionPlugin"
        }
        create("androidCompose") {
            id = "theya.android.compose"
            implementationClass = "com.theya.buildlogic.AndroidComposeConventionPlugin"
        }
        create("androidHilt") {
            id = "theya.android.hilt"
            implementationClass = "com.theya.buildlogic.AndroidHiltConventionPlugin"
        }
        create("jvmKotlin") {
            id = "theya.jvm.kotlin"
            implementationClass = "com.theya.buildlogic.JvmKotlinConventionPlugin"
        }
    }
}