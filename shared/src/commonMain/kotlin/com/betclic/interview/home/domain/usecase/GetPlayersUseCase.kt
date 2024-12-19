package com.betclic.interview.home.domain.usecase

import com.betclic.interview.di.DiComponent
import com.betclic.interview.di.IsolatedKoinContext
import com.betclic.interview.home.domain.PlayersRepository
import com.betclic.interview.home.domain.model.Player
import org.koin.core.annotation.Factory

@Factory
internal class _GetPlayersUseCase(
    private val repository: PlayersRepository
): DiComponent() {
    suspend operator fun invoke(): List<Player> = repository.getPlayers()
}

open class GetPlayersUseCase {
    private val useCase = IsolatedKoinContext.koin.get<_GetPlayersUseCase>()

    suspend operator fun invoke(): List<Player> {
        return useCase.invoke()
    }
}