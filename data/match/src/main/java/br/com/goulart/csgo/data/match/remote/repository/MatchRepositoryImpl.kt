package br.com.goulart.csgo.data.match.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.goulart.csgo.data.match.datasource.MatchDataSource
import br.com.goulart.csgo.data.match.model.Match
import br.com.goulart.csgo.data.match.model.Matches
import br.com.goulart.csgo.data.match.repository.MatchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class MatchRepositoryImpl @Inject constructor(
    private val dataSource: MatchDataSource
) : MatchRepository {

    override fun getMatches(): Flow<PagingData<Match>> {
        return Pager(
            config = PagingConfig(pageSize = 10, maxSize = 500),
            pagingSourceFactory = { dataSource }
        ).flow
    }

}