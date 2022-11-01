package br.com.goulart.csgo.data.match.remote

import br.com.goulart.csgo.data.match.remote.MatchesConstants.PAGE_PATH
import br.com.goulart.csgo.data.match.remote.MatchesConstants.PER_PAGE_PATH
import br.com.goulart.csgo.data.match.remote.MatchesConstants.SORT
import br.com.goulart.csgo.data.match.remote.model.MatchResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MatchService {

    @GET(MatchesConstants.MATCHES_URL)
    suspend fun matches(
        @Query(PAGE_PATH) page: Int,
        @Query(PER_PAGE_PATH) perPage: Int,
        @Query(SORT) sort: String = "begin_at",
    ): List<MatchResponse>

}

internal object MatchesConstants {
    const val PAGE_PATH = "page"
    const val PER_PAGE_PATH = "per_page"
    const val SORT = "sort"

    const val MATCHES_URL = "csgo/matches"
}