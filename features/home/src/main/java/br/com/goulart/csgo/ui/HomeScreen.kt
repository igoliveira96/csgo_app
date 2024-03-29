package br.com.goulart.csgo.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import br.com.goulart.csgo.R
import br.com.goulart.csgo.components.MatchCard
import br.com.goulart.csgo.core.uikit.components.LoadingView
import br.com.goulart.csgo.core.uikit.components.PageTitle
import br.com.goulart.csgo.core.uikit.theme.CSGOTheme.colors

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val lazyPagingItems = viewModel.getMatches().collectAsLazyPagingItems()

    Column {
        PageTitle(title = R.string.matches)

        LazyColumn(
            contentPadding = PaddingValues(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items(lazyPagingItems) { match ->
                match?.let {
                    MatchCard(match)
                }
            }

            lazyPagingItems.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        item {
                            ShowLoading(modifier = Modifier.fillParentMaxSize())
                        }
                    }
                    loadState.append is LoadState.Loading -> {
                        item {
                            ShowLoading(modifier = Modifier.fillParentMaxWidth())
                        }
                    }
                    loadState.refresh is LoadState.Error -> {
                        val e = lazyPagingItems.loadState.refresh as LoadState.Error
                        item {
                            ShowError(
                                message = e.error.localizedMessage ?: stringResource(R.string.error_message),
                                modifier = Modifier.fillParentMaxSize(),
                                onClickRetry = { retry() }
                            )
                        }
                    }
                    loadState.append is LoadState.Error -> {
                        val e = lazyPagingItems.loadState.append as LoadState.Error
                        item {
                            ShowError(
                                message = e.error.localizedMessage ?: stringResource(R.string.error_message),
                                onClickRetry = { retry() }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ShowLoading(modifier: Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LoadingView()
    }
}

@Composable
private fun ShowError(
    modifier: Modifier = Modifier,
    message: String,
    onClickRetry: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = message,
            color = colors.imperialRed,
            style = TextStyle.Default.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight.W500
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onClickRetry,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colors.lotion20Percent,
            )
        ) {
            Text(
                text = stringResource(R.string.try_again),
                color = Color.White,
                style = TextStyle.Default.copy(
                    fontSize = 16.sp
                )
            )
        }
    }
}