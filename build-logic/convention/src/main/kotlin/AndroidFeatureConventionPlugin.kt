import com.google.samples.apps.nowinandroid.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("bootlogger.android.library")
                apply("bootlogger.android.hilt")
            }

            dependencies {
                add("implementation", project(":core:model"))
                add("implementation", project(":core:ui"))

                add("testImplementation", kotlin("test"))
                add("androidTestImplementation", kotlin("test"))

                add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())
            }
        }
    }
}
