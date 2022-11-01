package br.com.goulart.csgo.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.goulart.csgo.components.MatchCard
import br.com.goulart.csgo.core.uikit.components.Loading

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column {
        Text(
            modifier = Modifier.padding(24.dp),
            text = "Partidas",
            color = Color.White,
            style = TextStyle.Default.copy(
                fontSize = 32.sp,
                fontWeight = FontWeight.W500
            )
        )

        if (state.loading) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Loading()
            }
        }

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items(state.matches.matches) { match ->
                MatchCard(match)
            }
        }
    }
}