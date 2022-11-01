package br.com.goulart.csgo.data.match.remote.model

import com.google.gson.annotations.SerializedName

internal data class OpponentResponse (
    @SerializedName("acronym") val acronym: String? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("image_url") val imageUrl: String? = null,
    @SerializedName("location") val location: String? = null,
    @SerializedName("modified_at") val modifiedAt: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("slug") val slug: String? = null
)