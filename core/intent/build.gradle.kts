plugins {
    id("com.android.library")
    id("kotlin-android")
}

apply {
    from("$rootDir/android-common.gradle")
}

android {
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["compose_version"] as String
    }
}

dependencies {

    val core = Dependencies.Modules.Core
    val compose = Dependencies.Compose
    val external = Dependencies.External
    val features = Dependencies.Modules.Features

    implementation(project(core.uikit))

    implementation(project(features.home))

    implementation(compose.navigation)
    implementation(compose.navigationCommon)

    implementation(external.gson)
    implementation(external.hiltCompose)

    testImplementation(Dependencies.Test.jUnit)

}