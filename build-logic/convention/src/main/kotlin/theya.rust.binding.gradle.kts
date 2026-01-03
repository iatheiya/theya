import org.gradle.api.Plugin
import org.gradle.api.Project

class RustBindingConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.mozilla.rust-android-gradle.rust-android")
            }
        }
    }
}
