package br.com.goulart.csgo.data.match.usecase

import br.com.goulart.csgo.core.commons.UseCase
import br.com.goulart.csgo.data.match.model.Matches
import br.com.goulart.csgo.data.match.repository.MatchRepository
import br.com.goulart.csgo.core.di.core.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMatchesUseCase @Inject constructor(
    private val repository: MatchRepository,
    @ApplicationScope coroutineScope: CoroutineScope
) : UseCase<Matches, GetMatchesUseCase.Params>(coroutineScope) {

    override fun run(params: Params?): Flow<Matches> = when(params) {
        null -> throw Throwable()
        else -> repository.getMatches(params.page, params.perPage)
    }

    data class Params(
        val page: Int,
        val perPage: Int
    )

}