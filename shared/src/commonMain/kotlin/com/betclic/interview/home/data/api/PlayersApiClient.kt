package com.betclic.interview.home.data.api

import com.betclic.interview.home.data.api.dto.PlayerDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Named

@Factory
internal class PlayersApiClient(
    @Named("playersUrl") private val ktorClient: HttpClient,
) {

    suspend fun getPlayers(): List<PlayerDto> {
        return ktorClient.get("/players").body()
    }
}