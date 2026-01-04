plugins {
    `kotlin-dsl`
}

group = "com.theya.buildlogic"

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.hilt.android.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("theyaAndroidApplication") {
            id = "theya.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("theyaAndroidCompose") {
            id = "theya.android.compose"
            implementationClass = "theya.android.compose.gradle"
        }
        register("theyaAndroidHilt") {
            id = "theya.android.hilt"
            implementationClass = "theya.android.hilt.gradle"
        }
    }
}
