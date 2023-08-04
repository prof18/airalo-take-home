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

include(":features:country-chooser:implementation")
include(":features:country-chooser:contract")
include(":features:country-packages:implementation")
include(":features:country-packages:contract")

include(":libraries:design-system")
include(":libraries:test-shared")
