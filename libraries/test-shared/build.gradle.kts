plugins {
    id("com.prof18.airalo.android.library")
}

android {
    namespace = "com.prof18.airalo.testshared"
}

dependencies {
    implementation(libs.kotlinx.coroutines.test)
    implementation(libs.androidx.test.rules)
}
