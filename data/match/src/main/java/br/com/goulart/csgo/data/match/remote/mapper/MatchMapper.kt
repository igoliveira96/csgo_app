package br.com.goulart.csgo.data.match.remote.mapper

import br.com.goulart.csgo.core.network.mapper.BaseMapper
import br.com.goulart.csgo.data.match.model.Match
import br.com.goulart.csgo.data.match.remote.model.MatchResponse

internal object MatchMapper : BaseMapper<MatchResponse, Match> {

    override fun toDomain(remote: MatchResponse): Match = Match(
        beginAt = remote.beginAt,
        opponents = OpponentsMapper.toDomain(remote.opponents),
        league = LeagueMapper.toDomain(remote.league),
        leagueSerie = SerieMapper.toDomain(remote.leagueSerie)
    )

    override fun fromDomain(domain: Match): MatchResponse = MatchResponse(
        beginAt = domain.beginAt,
        opponents = OpponentsMapper.fromDomain(domain.opponents),
        league = LeagueMapper.fromDomain(domain.league),
        leagueSerie = SerieMapper.fromDomain(domain.leagueSerie)
    )

}