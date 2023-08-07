plugins {
    id("com.prof18.airalo.android.feature")
    id("com.prof18.airalo.android.library.compose")
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.prof18.airalo.countrychooser"
}

dependencies {
    implementation(project(":features:country-packages:contract"))
    implementation(project(":features:country-chooser:contract"))
    implementation(project(":libraries:design-system"))

    implementation(libs.com.squareup.retrofit)
    implementation(libs.com.jakewharton.timber)
    implementation(libs.io.coil.compose)

    implementation(libs.com.squareup.moshi)
    ksp(libs.com.squareup.moshi.kotlin.codegen)
    testImplementation(project(":libraries:test-utils"))

    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.app.cash.turbine)
}
