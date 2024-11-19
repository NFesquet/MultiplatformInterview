package com.betclic.interview.home.data

import com.betclic.interview.home.data.api.PlayersApiClient
import com.betclic.interview.home.data.api.dto.PlayerDtoMapper
import com.betclic.interview.home.domain.PlayersRepository
import com.betclic.interview.home.domain.model.Player
import org.koin.core.annotation.Single

@Single
internal class PlayersDataRepository(
    private val playersApiClient: PlayersApiClient,
    private val playerDtoMapper: PlayerDtoMapper,
) : PlayersRepository {

    override suspend fun getPlayers(): List<Player> {
        return playersApiClient.getPlayers()
            .let(playerDtoMapper::map)
    }
}