object Dependencies {

    object Modules {

        object Core {
            const val uikit = ":core:uikit"
            const val intent = ":core:intent"
            const val di = ":core:di"
        }

        object Features {
            const val home = ":features:home"
        }

    }

    object Android {
        const val coreKtx = "androidx.core:core-ktx:${Versions.Android.coreKtx}"
        const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Android.lifecycle}"
        const val lifecycleCompose = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.Android.lifecycle}"
        const val desbugar = "com.android.tools:desugar_jdk_libs:${Versions.Android.desbugar}"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.Compose.core}"
        const val material = "androidx.compose.material:material:${Versions.Compose.core}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.Compose.core}"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.Compose.core}"
        const val uiUtil = "androidx.compose.ui:ui-util:${Versions.Compose.core}"
        const val activity = "androidx.activity:activity-compose:${Versions.Compose.activity}"
        const val coil = "io.coil-kt:coil-compose:${Versions.Compose.coil}"
        const val accompanistSystemUi = "com.google.accompanist:accompanist-systemuicontroller:${Versions.Compose.accompanist}"
        const val navigation = "androidx.navigation:navigation-compose:${Versions.Compose.navigation}"
        const val navigationCommon = "androidx.navigation:navigation-common-ktx:${Versions.Compose.navigation}"
        const val accompanistPager = "com.google.accompanist:accompanist-pager:${Versions.Compose.accompanist}"
        const val accompanistPagerIndicators = "com.google.accompanist:accompanist-pager-indicators:${Versions.Compose.accompanist}"
    }

    object External {
        const val gson = "com.google.code.gson:gson:${Versions.External.gson}"
        const val hilt = "com.google.dagger:hilt-android:${Versions.External.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.External.hilt}"
        const val hiltCompose = "androidx.hilt:hilt-navigation-compose:${Versions.External.hiltCompose}"
    }

    object Test {
        const val jUnit = "junit:junit:${Versions.Test.jUnit}"
    }

}