pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
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
