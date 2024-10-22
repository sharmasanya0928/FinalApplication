plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt") // For annotation processing (Hilt)
    id("dagger.hilt.android.plugin") // Hilt for dependency injection
    id("jacoco") // Jacoco plugin for code coverage
}

android {
    namespace = "com.example.finalapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.finalapplication"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
    }
}

dependencies {
    // AndroidX, UI libraries, and Hilt for Dependency Injection
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Hilt for dependency injection
    implementation("com.google.dagger:hilt-android:2.48")
    implementation(libs.androidx.espresso.intents)
    kapt("com.google.dagger:hilt-compiler:2.48")

    // Networking dependencies: Retrofit and OkHttp for networking and logging
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")

    // Force a specific version of Guava and exclude listenablefuture to resolve conflict
    implementation("com.google.guava:guava:30.1.1-android") {
        exclude(group = "com.google.guava", module = "listenablefuture")
    }

    // Unit testing dependencies: JUnit and Mockito for mocking
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito:mockito-core:3.9.0")
    testImplementation("org.mockito:mockito-inline:3.9.0")

    // Arch core testing library for ViewModel and LiveData testing
    testImplementation("androidx.arch.core:core-testing:2.1.0")

    // Espresso for UI testing
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    // MockWebServer for testing API responses in unit tests
    testImplementation("com.squareup.okhttp3:mockwebserver:4.9.0")
}

kapt {
    correctErrorTypes = true
}

// Configure Jacoco for code coverage
jacoco {
    toolVersion = "0.8.7"
}

tasks.withType<Test> {
    extensions.configure(JacocoTaskExtension::class) {
        isIncludeNoLocationClasses = true
    }
}

// Create a Jacoco report task for unit tests
tasks.register<JacocoReport>("jacocoTestReport") {
    dependsOn("testDebugUnitTest") // Depends on running the unit tests

    reports {
        xml.required.set(true)
        html.required.set(true)
    }

    // Use the correct paths for Android tests
    classDirectories.setFrom(
        fileTree(
            mapOf(
                "dir" to "${buildDir}/intermediates/javac/debug",
                "includes" to listOf("**/com/example/finalapplication/**")
            )
        )
    )

    sourceDirectories.setFrom(files("src/main/java"))
    executionData.setFrom(fileTree("${buildDir}") {
        include("**/jacoco/testDebugUnitTest.exec")
    })
}

configurations.all {
    resolutionStrategy {
        // Enforce a specific version of guava and avoid listenablefuture conflicts
        force("com.google.guava:guava:30.1.1-android")
        exclude(group = "com.google.guava", module = "listenablefuture")
    }
}
