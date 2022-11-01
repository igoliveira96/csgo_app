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

dependencies {

    val core = Dependencies.Modules.Core
    val external = Dependencies.External

    implementation(project(core.commons))
    implementation(project(core.di))
    implementation(project(core.network))

    implementation(external.coroutinesCore)
    implementation(external.retrofit)
    implementation(external.gson)
    implementation(external.okHttp)
    implementation(external.retrofitConverterGson)
    implementation(external.okHttpLoggingInterceptor)

    implementation(Dependencies.External.hilt)
    kapt(Dependencies.External.hiltCompiler)

}

kapt {
    correctErrorTypes = true
}