import com.android.build.api.dsl.ApplicationExtension
import com.prof18.airalo.convention.ANDROID_TARGET_SDK_VERSION
import com.prof18.airalo.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure


/**
 * Setup the Android Application module
 *
 * Plugin id: `com.prof18.airalo.android.application`
 */
class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)

                defaultConfig {
                    targetSdk = target.ANDROID_TARGET_SDK_VERSION

                    buildTypes {
                        getByName("release") {
                            isMinifyEnabled = false
                            proguardFiles(
                                getDefaultProguardFile("proguard-android-optimize.txt"),
                                "proguard-rules.pro",
                            )
                        }
                    }
                }
            }
        }
    }
}
