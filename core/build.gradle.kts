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
