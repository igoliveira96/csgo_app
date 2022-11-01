package br.com.goulart.csgo.core.uikit.components

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import br.com.goulart.csgo.core.uikit.theme.CSGOTheme.colors

@Composable
fun Loading() {
    CircularProgressIndicator(
        color = colors.white50Percent
    )
}