import com.android.build.gradle.LibraryExtension
import com.prof18.airalo.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

/**
 * Provide a common setup for the features modules
 *
 * Plugin id: `com.prof18.airalo.android.feature`
 */
class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.prof18.airalo.android.library")
                apply("com.prof18.airalo.android.library.koin.annotations")
            }

            extensions.configure<LibraryExtension> {
                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
            }

            dependencies {
                add("implementation", project(":core"))
                add("implementation", libs.findBundle("koin").get())

                add("testImplementation", kotlin("test"))
                add("testImplementation", libs.findLibrary("junit").get())
            }
        }
    }
}
