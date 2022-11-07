package br.com.goulart.csgo.data.match.model

data class League(
    val id: Int,
    val imageUrl: String?,
    val name: String
) {

    companion object {
        val EXAMPLE = League(
            id = 4243,
            imageUrl = null,
            name = "ESEA"
        )
    }

}
