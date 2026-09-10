plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}

dependencies{
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.koin.core)

    // 1. Core JUnit Framework
    testImplementation(libs.junit)
    // 2. Mocking (Choose MockK for Kotlin)
    testImplementation(libs.mockk)
    // 3. Jetpack Architecture & Coroutines
    testImplementation(libs.kotlinx.coroutines.test)
    // 4. Fluent Assertions
    testImplementation(libs.truth)
    // 5. Android Framework Shadowing (Optional)
    testImplementation(libs.robolectric)

    implementation(project(":core-common"))
}


