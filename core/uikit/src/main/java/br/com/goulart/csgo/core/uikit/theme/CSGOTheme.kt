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
    val raisinBlack = CSGOTheme.colors.raisinBlack
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

object CSGOTheme {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current
}