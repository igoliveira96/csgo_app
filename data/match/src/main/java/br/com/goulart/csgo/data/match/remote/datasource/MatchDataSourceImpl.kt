package br.com.goulart.csgo.data.match.remote.datasource

import androidx.paging.PagingState
import br.com.goulart.csgo.data.match.datasource.MatchDataSource
import br.com.goulart.csgo.data.match.model.Match
import br.com.goulart.csgo.data.match.remote.MatchService
import br.com.goulart.csgo.data.match.remote.mapper.MatchesMapper
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

internal class MatchDataSourceImpl @Inject constructor(
    private val service: MatchService
) : MatchDataSource() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Match> {
        return try {
            val result = MatchesMapper.toDomain(
                service.matches(
                    page = params.key ?: STARTING_PAGE_INDEX,
                    perPage = 10
                )
            )
            LoadResult.Page(
                data = result.matches,
                prevKey = params.key,
                nextKey = params.key?.plus(1) ?: STARTING_PAGE_INDEX.plus(1)
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }

    override fun getRefreshKey(state: PagingState<Int, Match>): Int? {
        return state.anchorPosition
    }

}