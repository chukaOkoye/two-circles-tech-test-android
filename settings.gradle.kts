pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "SuperScoreBoard"
include(":app")

include(":data")
include(":data:feature")
include(":data:feature:fixtures")
include(":data:network")

include(":domain")
include(":domain:common")
include(":domain:common:model")
include(":domain:feature")
include(":domain:feature:fixtures")

include(":ui")

include(":ui:theme")
include(":ui:feature:fixtures")
