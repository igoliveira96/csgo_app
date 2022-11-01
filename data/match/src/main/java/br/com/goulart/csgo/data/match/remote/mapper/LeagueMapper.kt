package br.com.goulart.csgo.data.match.remote.mapper

import br.com.goulart.csgo.core.network.mapper.BaseMapper
import br.com.goulart.csgo.data.match.model.League
import br.com.goulart.csgo.data.match.remote.model.LeagueResponse

internal object LeagueMapper : BaseMapper<LeagueResponse, League> {

    override fun toDomain(remote: LeagueResponse): League = League(
        id = remote.id,
        imageUrl = remote.imageUrl,
        name = remote.name
    )

    override fun fromDomain(domain: League): LeagueResponse = LeagueResponse(
        id = domain.id,
        imageUrl = domain.imageUrl,
        name = domain.name
    )
}