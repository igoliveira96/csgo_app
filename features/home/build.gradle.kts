plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

apply {
    from("$rootDir/android-common.gradle")
}

android {
    buildFeatures {
        compose = true
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["compose_version"] as String
    }
}

dependencies {

    val core = Dependencies.Modules.Core
    val features = Dependencies.Modules.Features
    val android = Dependencies.Android
    val compose = Dependencies.Compose

    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.uiToolingPreview)
    implementation(Dependencies.Compose.coil)
    implementation(compose.accompanistPager)
    implementation(compose.accompanistPagerIndicators)
    implementation(Dependencies.Compose.coil)
    implementation(Dependencies.Android.lifecycleViewModel)
    implementation(Dependencies.Android.lifecycleCompose)
    coreLibraryDesugaring(android.desbugar)

    implementation(Dependencies.External.hilt)
    kapt(Dependencies.External.hiltCompiler)
    implementation (Dependencies.External.hiltCompose)

    implementation(project(core.uikit))

    testImplementation(Dependencies.Test.jUnit)
    debugImplementation(Dependencies.Compose.uiTooling)
}

kapt {
    correctErrorTypes = true
}