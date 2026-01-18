import org.gradle.api.artifacts.VersionCatalogsExtension

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
        maven("https://maven.pkg.jetbrains.space/public/p/kotlin/p/dev")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        google()
    }
    resolutionStrategy {
        eachPlugin {
            val libs = extensions.getByType(VersionCatalogsExtension::class.java).named("libs")
            when (requested.id.id) {
                "com.android.application" -> useModule("com.android.tools.build:gradle:${libs.findVersion("agp").get().requiredVersion}")
                "com.android.library" -> useModule("com.android.tools.build:gradle:${libs.findVersion("agp").get().requiredVersion}")
                "org.jetbrains.kotlin.android" -> useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.findVersion("kotlin").get().requiredVersion}")
                "org.jetbrains.kotlin.jvm" -> useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.findVersion("kotlin").get().requiredVersion}")
                "org.jetbrains.kotlin.kapt" -> useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.findVersion("kotlin").get().requiredVersion}")
                "org.jetbrains.kotlin.plugin.compose" -> useModule("org.jetbrains.kotlin:compose-compiler-gradle-plugin:${libs.findVersion("kotlin").get().requiredVersion}")
                "com.google.dagger.hilt.android" -> useModule("com.google.dagger:hilt-android-gradle-plugin:${libs.findVersion("hilt").get().requiredVersion}")
                "io.github.MatrixDev.android-rust" -> useModule("io.github.MatrixDev:android-rust:${libs.findVersion("rustAndroid").get().requiredVersion}")
            }
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    versionCatalogs {
        create("libs") {
            from(files("gradle/libs.versions.toml"))
        }
    }
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://plugins.gradle.org/m2/")
        maven("https://maven.pkg.jetbrains.space/public/p/kotlin/p/dev")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        google()
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
