plugins {
    id("com.prof18.airalo.android.feature")
    id("com.prof18.airalo.android.library.compose")
}

android {
    namespace = "com.prof18.airalo.countrypackages"
}

dependencies {
    implementation(project(":features:country-packages:contract"))
    implementation(project(":libraries:design-system"))

    implementation(libs.com.jakewharton.timber)
}
