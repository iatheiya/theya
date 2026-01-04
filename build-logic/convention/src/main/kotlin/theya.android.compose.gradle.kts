import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.findByType

val commonExtension = extensions.findByType<CommonExtension<*, *, *, *, *, *>>()

if (commonExtension == null) {
    error("Android extension not found. Ensure 'theya.android.application' or 'theya.android.library' is applied before 'theya.android.compose'.")
}

commonExtension.apply {
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
