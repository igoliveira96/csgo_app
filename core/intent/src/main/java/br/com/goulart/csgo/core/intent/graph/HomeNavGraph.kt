package br.com.goulart.csgo.core.intent.graph

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import br.com.goulart.csgo.core.intent.destination.HomeDestination
import br.com.goulart.csgo.core.intent.destination.ParentDestination
import br.com.goulart.csgo.ui.HomeScreen

fun NavGraphBuilder.addHomeNavGraph() {
    navigation(
        route = ParentDestination.Home.route,
        startDestination = HomeDestination.Matches.createRoute()
    ) {
        addMatches()
    }
}

private fun NavGraphBuilder.addMatches() {
    composable(HomeDestination.Matches.createRoute()) {
        HomeScreen(viewModel = hiltViewModel())
    }
}