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
        flatDir {
            dirs("unityLibrary/libs")
        }
    }
}

rootProject.name = "AR Project"
include(":app", ":unityLibrary")
project(":unityLibrary").projectDir = file("unityLibrary")

include(":unityLibrary:xrmanifest.androidlib")
project(":unityLibrary:xrmanifest.androidlib").projectDir = file("unityLibrary/xrmanifest.androidlib")
