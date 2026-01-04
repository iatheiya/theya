pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://plugins.gradle.org/m2/")
         maven("https://maven.pkg.jetbrains.space/public/p/kotlin/p/dev")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://plugins.gradle.org/m2/")
         maven("https://maven.pkg.jetbrains.space/public/p/kotlin/p/dev")
    }
}

rootProject.name = "Theya"

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
