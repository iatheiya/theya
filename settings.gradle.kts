pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/kotlin/p/dev")
        maven("https://raw.githubusercontent.com/mozilla/rust-android-gradle/main/maven")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/kotlin/p/dev")
    }
}

rootProject.name = "Theya"

includeBuild("build-logic")

include(":app")
include(":modules:system:glue-jni")
include(":modules:core:common")
include(":modules:core:datastore")
include(":modules:core:rust-sdk")
include(":modules:core:api")
include(":modules:core:models")
include(":modules:core:usecases")
include(":modules:core:network")
include(":modules:features:dashboard")
include(":modules:features:terminal")
include(":modules:features:bridge-explorer")
include(":modules:features:shell-setup")
include(":modules:runtime:session-service")
