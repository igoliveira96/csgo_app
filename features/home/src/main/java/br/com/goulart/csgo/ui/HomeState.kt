package br.com.goulart.csgo.ui

import br.com.goulart.csgo.data.match.model.Matches

data class HomeState(
    val loading: Boolean = false,
    val matches: Matches = Matches(matches = emptyList())
)
