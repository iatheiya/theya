plugins {
    alias(libs.plugins.jetbrains-kotlin-jvm)
    id("java-gradle-plugin")
}

group = "com.theya.buildlogic"

kotlin {
    jvmToolchain(17)
}

dependencies {
    compileOnly(gradleApi())
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.hilt.gradlePlugin)
    compileOnly(libs.kotlin.compose.compiler.plugin)
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
