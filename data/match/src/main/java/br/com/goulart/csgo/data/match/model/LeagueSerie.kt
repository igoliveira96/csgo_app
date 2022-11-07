package br.com.goulart.csgo.data.match.model

data class LeagueSerie(
    val id: Int,
    val name: String
) {

    companion object {
        val EXAMPLE = LeagueSerie(
            id = 5209,
            name = "Advanced Europe"
        )
    }

}