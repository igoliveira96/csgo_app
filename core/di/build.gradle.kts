plugins {
    id("com.android.library")
    id("kotlin-android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

apply {
    from("$rootDir/android-common.gradle")
}

dependencies {

    val core = Dependencies.Modules.Core
    val features = Dependencies.Modules.Features
    val external = Dependencies.External

    implementation(project(core.intent))

    implementation(project(features.home))

    implementation(external.hilt)
    kapt(external.hiltCompiler)
    implementation (external.hiltCompose)
}

kapt {
    correctErrorTypes = true
}