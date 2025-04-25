plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}

allprojects {
    repositories {
        google()  // This is required for Android libraries
        mavenCentral()  // Include Maven Central for other dependencies
    }
}
