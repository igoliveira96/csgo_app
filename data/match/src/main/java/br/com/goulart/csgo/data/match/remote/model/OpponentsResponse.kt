package br.com.goulart.csgo.data.match.remote.model

import com.google.gson.annotations.SerializedName

internal data class OpponentsResponse(
    @SerializedName("opponent") val opponent: OpponentResponse,
    @SerializedName("type") val type: String
)
