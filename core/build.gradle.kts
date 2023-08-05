import java.util.Properties

plugins {
    id("com.prof18.airalo.android.base.library")
    id("com.prof18.airalo.android.library.koin.annotations")
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.prof18.airalo.core"

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        getByName("release") {
            // Network API key
            buildConfigField(
                "String",
                "API_KEY",
                "\"${"apiKey".byProperty ?: System.getenv("API_KEY")}\"",
            )
        }
        getByName("debug") {
            // Network API key
            buildConfigField(
                "String",
                "API_KEY",
                "\"${"apiKey".byProperty ?: System.getenv("API_KEY")}\"",
            )
        }
    }
}

dependencies {
    implementation(libs.com.squareup.retrofit)
    implementation(libs.com.squareup.retrofit.converter.moshi)
    implementation(libs.com.squareup.moshi)
    implementation(libs.com.squareup.okhttp3.okhttp)
    implementation(libs.com.squareup.okhttp3.logging.interceptor)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.core.ktx)
    implementation(libs.koin.core)

    ksp(libs.com.squareup.moshi.kotlin.codegen)
}

val String.byProperty: String?
    get() {
        val local = Properties()
        val localProperties: File = rootProject.file("local.properties")
        if (localProperties.exists()) {
            localProperties.inputStream().use { local.load(it) }
            return local.getProperty(this)
        }
        return null
    }
