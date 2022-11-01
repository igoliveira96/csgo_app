package br.com.goulart.csgo.data.match.remote.model

import com.google.gson.annotations.SerializedName

internal data class LeagueResponse(
    @SerializedName("id" ) val id: Int,
    @SerializedName("image_url") val imageUrl: String?,
    @SerializedName("name") val name: String
)
