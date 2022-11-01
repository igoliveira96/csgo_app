package br.com.goulart.csgo.data.match.remote.datasource

import br.com.goulart.csgo.data.match.datasource.MatchDataSource
import br.com.goulart.csgo.data.match.model.Matches
import br.com.goulart.csgo.data.match.remote.MatchService
import br.com.goulart.csgo.data.match.remote.mapper.MatchesMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class MatchDataSourceImpl @Inject constructor(
    private val matchService: MatchService
) : MatchDataSource {

    override fun getMatches(page: Int, perPage: Int): Flow<Matches> = flow {
        emit(
            MatchesMapper.toDomain(
                matchService.matches(page = page, perPage = perPage)
            )
        )
    }

}