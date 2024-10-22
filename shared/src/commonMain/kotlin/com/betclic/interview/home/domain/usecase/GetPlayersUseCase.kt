package com.betclic.interview.home.domain.usecase

import com.betclic.interview.home.domain.PlayersRepository

internal class GetPlayersUseCase(
    private val repository: PlayersRepository
) {
    suspend operator fun invoke() = repository.getPlayers()
}