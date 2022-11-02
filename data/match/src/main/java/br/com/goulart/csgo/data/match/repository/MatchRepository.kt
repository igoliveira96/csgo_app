package br.com.goulart.csgo.data.match.repository

import androidx.paging.PagingData
import br.com.goulart.csgo.data.match.model.Match
import br.com.goulart.csgo.data.match.model.Matches
import kotlinx.coroutines.flow.Flow

interface MatchRepository {

    fun getMatches(): Flow<PagingData<Match>>

}