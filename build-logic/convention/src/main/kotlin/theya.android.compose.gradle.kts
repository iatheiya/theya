import com.android.build.api.dsl.CommonExtension

val commonExtension = extensions.findByType<CommonExtension<*, *, *, *, *, *>>()

commonExtension?.apply {
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.findVersion("kotlin").get().toString()
    }
}

dependencies {
    val bom = libs.findLibrary("androidx.compose.bom").get()
    add("implementation", platform(bom))
    add("androidTestImplementation", platform(bom))
    
    add("implementation", libs.findLibrary("androidx.ui").get())
    add("implementation", libs.findLibrary("androidx.ui.graphics").get())
    add("implementation", libs.findLibrary("androidx.ui.tooling.preview").get())
    add("implementation", libs.findLibrary("androidx.material3").get())
    add("debugImplementation", libs.findLibrary("androidx.ui.tooling").get())
}
