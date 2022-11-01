package br.com.goulart.csgo.data.match.di

import br.com.goulart.csgo.core.network.core.Retrofit
import br.com.goulart.csgo.data.match.remote.TokenInterceptor
import br.com.goulart.csgo.data.match.datasource.MatchDataSource
import br.com.goulart.csgo.data.match.remote.MatchService
import br.com.goulart.csgo.data.match.remote.NetworkConnection
import br.com.goulart.csgo.data.match.remote.datasource.MatchDataSourceImpl
import br.com.goulart.csgo.data.match.remote.repository.MatchRepositoryImpl
import br.com.goulart.csgo.data.match.repository.MatchRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MatchModule {

    @Singleton
    @Provides
    internal fun providesTokenInterceptor() = TokenInterceptor()

    @Singleton
    @Provides
    internal fun providesMatchService(
        tokenInterceptor: TokenInterceptor
    ): MatchService = Retrofit(
        interceptor = tokenInterceptor,
        baseUrl = NetworkConnection.PANDA_SCORE,
    )

    @Singleton
    @Provides
    internal fun providesMatchDataSource(
        matchDataSourceImpl: MatchDataSourceImpl
    ): MatchDataSource = matchDataSourceImpl

}


@Module
@InstallIn(SingletonComponent::class)
internal abstract class MatchRepositoryModule {

    @Binds
    internal abstract fun bindsMatchRepository(
        matchRepositoryImpl: MatchRepositoryImpl
    ): MatchRepository

}

//@Module
//@InstallIn(SingletonComponent::class)
//internal abstract class MatchDataSourceModule {
//
//    @Binds
//    internal abstract fun bindsMatchDataSource(
//        matchDataSourceImpl: MatchDataSourceImpl
//    ): MatchDataSource
//
//}