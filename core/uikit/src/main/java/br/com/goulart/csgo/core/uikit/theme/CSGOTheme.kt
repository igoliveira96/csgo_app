package br.com.goulart.csgo.core.uikit.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

val LocalAppColors = compositionLocalOf { AppColors() }

@Composable
fun CSGOTheme(
    content: @Composable () -> Unit
) {
    val backgroundColor = CSGOTheme.colors.backgroundColor
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(color = backgroundColor)
        systemUiController.setNavigationBarColor(color = Color.Black)
    }
    CompositionLocalProvider(
        LocalAppColors provides AppColors(),
    ) {
        MaterialTheme(content = content)
    }
}

object CSGOTheme {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current
}