package br.com.goulart.csgo.data.match.remote.repository

import br.com.goulart.csgo.data.match.datasource.MatchDataSource
import br.com.goulart.csgo.data.match.model.Matches
import br.com.goulart.csgo.data.match.repository.MatchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class MatchRepositoryImpl @Inject constructor(
    private val dataSource: MatchDataSource
) : MatchRepository {

    override fun getMatches(page: Int, perPage: Int): Flow<Matches> =
        dataSource.getMatches(page, perPage)

}