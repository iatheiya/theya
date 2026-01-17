plugins {
    id("org.jetbrains.kotlin.jvm") version "2.3.0"
    id("java-gradle-plugin")
}

group = "com.theya.buildlogic"

versionCatalogs {
    create("libs") {
        from(files("../../gradle/libs.versions.toml"))
    }
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    compileOnly(gradleApi())
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.hilt.gradlePlugin)
    implementation(libs.kotlin.compose.compiler.plugin)
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