package br.com.goulart.csgo.data.match.model

data class Match(
    val beginAt: String,
    val status: String,
    val opponents: List<Opponents>,
    val league: League,
    val leagueSerie: LeagueSerie
) {
    companion object {
        val EXAMPLE = Match(
            beginAt = "2022-11-10T20:00:00Z",
            status = "not_started",
            opponents = Opponents.EXAMPLE,
            league = League.EXAMPLE,
            leagueSerie = LeagueSerie.EXAMPLE
        )
    }
}
