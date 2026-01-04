pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/kotlin/p/dev")
    }
}

rootProject.name = "build-logic"
include(":convention")
