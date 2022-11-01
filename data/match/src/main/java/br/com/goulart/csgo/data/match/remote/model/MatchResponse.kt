package br.com.goulart.csgo.data.match.remote.model

import com.google.gson.annotations.SerializedName

internal data class MatchResponse(
    @SerializedName("begin_at") val beginAt: String,
    @SerializedName("opponents") val opponents: List<OpponentsResponse>,
    @SerializedName("league") val league: LeagueResponse,
    @SerializedName("serie") val leagueSerie: SerieResponse,
)
