pluginManagement {
    repositories {
        google()  // ✅ Debe estar aquí
        mavenCentral()  // ✅ Debe estar aquí
        gradlePluginPortal()  // 🔄 Lo dejamos al final
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "lagrnajadezenon"
include(":app")