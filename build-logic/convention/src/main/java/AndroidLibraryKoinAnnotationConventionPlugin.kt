import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

/**
 * Enable Koin Annotations in an Android library module
 *
 * Plugin id: `com.prof18.airalo.android.library.koin.annotations`
 */
class AndroidLibraryKoinAnnotationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.library")
            pluginManager.apply("com.google.devtools.ksp")

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                add("implementation", libs.findLibrary("koin.annotations").get())
                add("ksp", libs.findLibrary("koin.ksp.compiler").get())
            }
        }
    }
}
