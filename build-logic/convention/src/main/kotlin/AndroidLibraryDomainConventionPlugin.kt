import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidLibraryDomainConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("bootlogger.android.library")
                apply("bootlogger.android.hilt")
            }

            dependencies {
                add("implementation", project(":core:model"))
            }
        }
    }
}