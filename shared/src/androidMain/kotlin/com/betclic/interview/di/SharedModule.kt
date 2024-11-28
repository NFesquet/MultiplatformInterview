package com.betclic.interview.di

import android.content.Context
import com.betclic.interview.home.data.PlayersDataRepository
import com.betclic.interview.home.domain.PlayersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent.get
import org.koin.ksp.generated.module

@Module
@InstallIn(SingletonComponent::class)
class SharedModule {

    @Provides
    fun providePlayersRepository(): PlayersRepository {
        return get(PlayersDataRepository::class.java)
    }

    companion object {
        fun init(context: Context) {
            startKoin {
                modules(CommonModule().module)
            }
        }
    }
}