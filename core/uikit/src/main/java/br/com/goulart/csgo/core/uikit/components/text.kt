package br.com.goulart.csgo.core.uikit.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PageTitle(
    @StringRes title: Int,
) {
    Text(
        modifier = Modifier.padding(24.dp),
        text = stringResource(title),
        color = Color.White,
        style = TextStyle.Default.copy(
            fontSize = 32.sp,
            fontWeight = FontWeight.W500
        )
    )
}