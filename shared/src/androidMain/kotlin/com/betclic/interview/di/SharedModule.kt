package com.betclic.interview.di

import com.betclic.interview.home.domain.usecase.GetPlayersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SharedModule {

    @Provides
    fun provideGetPlayersUseCase(): GetPlayersUseCase {
        return GetPlayersUseCase()
    }
}