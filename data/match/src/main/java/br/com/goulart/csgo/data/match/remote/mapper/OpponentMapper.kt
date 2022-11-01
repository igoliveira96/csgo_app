package br.com.goulart.csgo.data.match.remote.mapper

import br.com.goulart.csgo.core.network.mapper.BaseMapper
import br.com.goulart.csgo.data.match.model.Opponent
import br.com.goulart.csgo.data.match.remote.model.OpponentResponse

internal object OpponentMapper : BaseMapper<OpponentResponse, Opponent> {

    override fun toDomain(remote: OpponentResponse): Opponent = Opponent(
        acronym = remote.acronym,
        id = remote.id,
        imageUrl = remote.imageUrl,
        location = remote.location,
        modifiedAt = remote.modifiedAt,
        name = remote.name,
        slug = remote.slug
    )

    override fun fromDomain(domain: Opponent): OpponentResponse = OpponentResponse(
        acronym = domain.acronym,
        id = domain.id,
        imageUrl = domain.imageUrl,
        location = domain.location,
        modifiedAt = domain.modifiedAt,
        name = domain.name,
        slug = domain.slug
    )
}