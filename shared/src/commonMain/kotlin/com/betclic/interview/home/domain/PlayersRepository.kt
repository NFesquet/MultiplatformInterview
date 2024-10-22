package com.betclic.interview.home.domain

import com.betclic.interview.home.domain.model.Player

internal interface PlayersRepository {

    suspend fun getPlayers(): List<Player>
}