plugins {
    id("com.prof18.airalo.android.application")
}

android {
    namespace = "com.prof18.airalo"

    defaultConfig {
        applicationId = "com.prof18.airalo.sample"
        versionCode = 1
        versionName = "1.0.0"
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":features:country-chooser:contract"))
    implementation(project(":features:country-chooser:impl"))
    implementation(project(":features:country-packages:contract"))
    implementation(project(":features:country-packages:impl"))
    implementation(project(":libraries:design-system"))

    implementation(libs.com.jakewharton.timber)
    implementation(libs.bundles.koin)

    testImplementation(libs.junit)
    testImplementation(libs.koin.test)

    debugImplementation(libs.com.squareup.leakcanary.android)
}
