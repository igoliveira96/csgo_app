package br.com.goulart.csgo.data.match.repository

import br.com.goulart.csgo.data.match.model.Matches
import kotlinx.coroutines.flow.Flow

interface MatchRepository {

    fun getMatches(page: Int, perPage: Int): Flow<Matches>

}