plugins {
    id("theya.android.application")
    id("theya.android.compose")
    id("theya.android.hilt")
}

android {
    namespace = "com.theya.app"
    
    defaultConfig {
        applicationId = "com.theya.app"
        versionCode = 1
        versionName = "0.1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":modules:system:glue-jni"))
    implementation(project(":modules:core:common"))
    implementation(project(":modules:core:datastore"))
    implementation(project(":modules:core:models"))
    implementation(project(":modules:core:api"))
    implementation(project(":modules:core:usecases"))
    implementation(project(":modules:features:dashboard"))
    implementation(project(":modules:features:terminal"))
    implementation(project(":modules:features:bridge-explorer"))
    implementation(project(":modules:features:shell-setup"))
    implementation(project(":modules:runtime:session-service"))

    implementation(libs.androidxCoreKtx)
    implementation(libs.androidxLifecycleRuntimeKtx)
    implementation(libs.androidxActivityCompose)
    implementation(libs.androidxNavigationCompose)
}