pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://plugins.gradle.org/m2/")

maven("https://maven.pkg.jetbrains.space/public/p/kotlin/p/dev")
    }
}

rootProject.name = "build-logic"
include(":convention")
