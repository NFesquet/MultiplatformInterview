package com.betclic.interview.di

import com.betclic.interview.home.domain.usecase.GetPlayersUseCase
import com.betclic.interview.ui.MainViewModel
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module
@ComponentScan("com.betclic.interview")
class AppModuleKoin {

    fun provideViewModel(getPlayersUseCase: GetPlayersUseCase): MainViewModel {
        return MainViewModel(getPlayersUseCase)
    }

}