package br.com.goulart.csgo.data.match.model

data class Opponents(
    val opponent: Opponent,
    val type: String
) {
    companion object {
        val EXAMPLE = listOf(
            Opponents(
                opponent = Opponent(
                    id = 131975,
                    acronym = null,
                    imageUrl = "https://cdn.pandascore.co/images/team/image/131975/148px_linx_legacy_2022_allmode.png",
                    location = "RU",
                    modifiedAt = "2022-10-25T06:36:37Z",
                    name = "Linx Legacy D",
                    slug = "linx-legacy-d"
                ),
                type = "Team"
            ),
            Opponents(
                opponent = Opponent(
                    id = 132061,
                    acronym = null,
                    imageUrl = null,
                    location = "",
                    modifiedAt = "2022-11-06T04:20:06Z",
                    name = "MALCO",
                    slug = "malco"
                ),
                type = "Team"
            )
        )
    }
}
