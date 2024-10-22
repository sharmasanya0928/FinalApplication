// Project-level build.gradle.kts

buildscript {
    repositories {
        google()          // Required for Android Gradle Plugin
        mavenCentral()    // Required for Kotlin, Hilt, and other dependencies
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.6.1")  // Android Gradle Plugin
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")  // Kotlin Gradle Plugin
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.48")  // Hilt Gradle Plugin

    }
}
