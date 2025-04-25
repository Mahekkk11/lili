pluginManagement {
    repositories {
        google()  // Required for Android libraries
        mavenCentral()  // For other dependencies
    }
}

dependencyResolutionManagement {
    repositories {
        google()  // Required for Android libraries
        mavenCentral()  // For other dependencies
    }
}

rootProject.name = "maps"
include(":app")  // Ensure the app module is correctly included
