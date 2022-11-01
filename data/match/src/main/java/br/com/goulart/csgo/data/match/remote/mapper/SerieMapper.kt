package br.com.goulart.csgo.data.match.remote.mapper

import br.com.goulart.csgo.core.network.mapper.BaseMapper
import br.com.goulart.csgo.data.match.model.LeagueSerie
import br.com.goulart.csgo.data.match.remote.model.SerieResponse

internal object SerieMapper : BaseMapper<SerieResponse, LeagueSerie> {

    override fun toDomain(remote: SerieResponse): LeagueSerie = LeagueSerie(
        id = remote.id,
        name = remote.name
    )

    override fun fromDomain(domain: LeagueSerie): SerieResponse = SerieResponse(
        id = domain.id,
        name = domain.name
    )

}