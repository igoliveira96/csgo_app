package br.com.goulart.csgo.data.match.datasource

import br.com.goulart.csgo.data.match.model.Matches
import kotlinx.coroutines.flow.Flow

internal interface MatchDataSource {

    fun getMatches(page: Int, perPage: Int): Flow<Matches>

}