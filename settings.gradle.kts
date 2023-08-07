pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "airalo-sample"

include(":app")
include(":core")

include(":features:country-chooser:impl")
include(":features:country-chooser:contract")
include(":features:country-packages:impl")
include(":features:country-packages:contract")

include(":libraries:design-system")
include(":libraries:test-shared")
