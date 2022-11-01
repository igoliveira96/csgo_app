package br.com.goulart.csgo.data.match.remote.model

import com.google.gson.annotations.SerializedName

internal data class SerieResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("full_name") val name: String
)