package br.com.goulart.csgo.core.di.intent

import br.com.goulart.csgo.core.intent.core.NavigationManager
import br.com.havaianas.seller.di.core.ApplicationScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal object NavigationModule {

    @Singleton
    @Provides
    internal fun providesNavigationManager(
        @ApplicationScope applicationScope: CoroutineScope
    ): NavigationManager {
        return NavigationManager(applicationScope)
    }

}