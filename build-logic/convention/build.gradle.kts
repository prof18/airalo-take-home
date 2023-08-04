plugins {
    `kotlin-dsl`
}

group = "com.prof18.airalo.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile::class.java).configureEach {
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    compileOnly(libs.com.android.tools.build.gradle)
    compileOnly(libs.org.jetbrains.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "com.prof18.airalo.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "com.prof18.airalo.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "com.prof18.airalo.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "com.prof18.airalo.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "com.prof18.airalo.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidBaseLibrary") {
            id = "com.prof18.airalo.android.base.library"
            implementationClass = "AndroidBaseLibraryConventionPlugin"
        }
        register("androidLibraryKoinAnnotations") {
            id = "com.prof18.airalo.android.library.koin.annotations"
            implementationClass = "AndroidLibraryKoinAnnotationConventionPlugin"
        }
    }
}
