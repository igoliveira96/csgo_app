package br.com.goulart.csgo.core.uikit.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

val LocalAppColors = compositionLocalOf { AppColors() }

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val raisinBlack = AppTheme.colors.raisinBlack
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(color = raisinBlack)
        systemUiController.setNavigationBarColor(color = Color.Black)
    }
    CompositionLocalProvider(
        LocalAppColors provides AppColors(),
    ) {
        MaterialTheme(content = content)
    }
}

object AppTheme {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current
}