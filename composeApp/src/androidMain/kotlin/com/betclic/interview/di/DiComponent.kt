package com.betclic.interview.di

import com.betclic.interview.home.domain.usecase.GetPlayersUseCase
import com.betclic.interview.ui.MainViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModel
import org.koin.ksp.generated.module

object DiComponent : KoinComponent {
    init {
        startKoin {
            modules(AppModuleKoin().module,
                module {
                    factory { GetPlayersUseCase() }
                    viewModel { MainViewModel(get()) }
                }
            )
        }
    }
}