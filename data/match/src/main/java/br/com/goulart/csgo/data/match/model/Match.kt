package br.com.goulart.csgo.data.match.model

data class Match(
    val beginAt: String,
    val opponents: List<Opponents>,
    val league: League,
    val leagueSerie: LeagueSerie
)
