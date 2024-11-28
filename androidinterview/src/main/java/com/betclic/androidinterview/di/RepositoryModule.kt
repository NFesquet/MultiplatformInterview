package com.betclic.androidinterview.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

//    @Binds
//    internal abstract fun bindPlayersRepository(playersDataRepository: PlayersDataRepository): PlayersRepository

//    @Binds
//    internal abstract fun bindPlayerDetailsRepository(playerDetailsDataRepository: PlayerDetailsDataRepository): PlayerDetailsRepository
}