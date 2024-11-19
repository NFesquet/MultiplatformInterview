package com.betclic.interview.di

import com.betclic.interview.home.domain.usecase._GetPlayersUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

internal object DiComponent: KoinComponent {
    init {
        startKoin {
            modules(CommonModule().module)
        }
    }

    val getPlayersUseCase: _GetPlayersUseCase by inject()
}