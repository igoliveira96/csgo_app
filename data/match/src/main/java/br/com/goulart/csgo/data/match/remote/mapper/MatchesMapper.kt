package br.com.goulart.csgo.data.match.remote.mapper

import br.com.goulart.csgo.core.network.mapper.BaseMapper
import br.com.goulart.csgo.data.match.model.Matches
import br.com.goulart.csgo.data.match.remote.model.MatchResponse

internal object MatchesMapper : BaseMapper<List<MatchResponse>, Matches> {
    override fun toDomain(remote: List<MatchResponse>): Matches =
        Matches(matches = MatchMapper.toDomain(remote))

    override fun fromDomain(domain: Matches): List<MatchResponse> =
        MatchMapper.fromDomain(domain.matches)


}