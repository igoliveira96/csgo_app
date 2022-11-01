package br.com.goulart.csgo.data.match.remote.mapper

import br.com.goulart.csgo.core.network.mapper.BaseMapper
import br.com.goulart.csgo.data.match.model.Opponents
import br.com.goulart.csgo.data.match.remote.model.OpponentsResponse

internal object OpponentsMapper : BaseMapper<OpponentsResponse, Opponents> {

    override fun toDomain(remote: OpponentsResponse): Opponents = Opponents(
        opponent = OpponentMapper.toDomain(remote.opponent),
        type = remote.type
    )

    override fun fromDomain(domain: Opponents): OpponentsResponse = OpponentsResponse(
        opponent = OpponentMapper.fromDomain(domain.opponent),
        type = domain.type
    )

}