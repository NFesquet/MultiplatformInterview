package com.betclic.interview.di

import com.betclic.interview.home.data.PlayersDataRepository
import com.betclic.interview.home.data.api.PlayersApiClient
import com.betclic.interview.home.data.api.dto.PlayerDtoMapper
import com.betclic.interview.home.domain.PlayersRepository
import com.betclic.interview.home.domain.usecase.GetPlayersUseCase
import io.ktor.client.HttpClient
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val commonModule = module {
    factoryOf(::PlayerDtoMapper)
    factory {
        HttpClient() {
//            install(JsonFeature) {
//                serializer = KotlinxSerializer()
//            }
        }
    }
    factory {
        PlayersApiClient(
            ktorClient = get()
        )
    }
    single<PlayersRepository> {
        PlayersDataRepository(
            playersApiClient = get(),
            playerDtoMapper = get(),
        )
    }
    factory {
        GetPlayersUseCase(
            repository = get(),
        )
    }
}