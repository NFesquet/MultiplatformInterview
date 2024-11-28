package com.betclic.androidinterview.di

import com.betclic.interview.details.data.PlayerDetailsDataRepository
import com.betclic.interview.details.domain.PlayerDetailsRepository
import com.betclic.interview.home.data.PlayersDataRepository
import com.betclic.interview.home.domain.PlayersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    internal abstract fun bindPlayersRepository(playersDataRepository: PlayersDataRepository): PlayersRepository

    @Binds
    internal abstract fun bindPlayerDetailsRepository(playerDetailsDataRepository: PlayerDetailsDataRepository): PlayerDetailsRepository
}