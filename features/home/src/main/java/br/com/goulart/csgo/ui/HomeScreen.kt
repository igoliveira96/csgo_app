package br.com.goulart.csgo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.goulart.csgo.core.uikit.components.MatchCard

@Composable
fun HomeScreen() {
    LazyColumn(
        contentPadding = PaddingValues(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        item {
            Text(
                text = "Partidas",
                color = Color.White,
                style = TextStyle.Default.copy(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.W500
                )
            )
        }

        items(5) {
            MatchCard()
        }
    }
}