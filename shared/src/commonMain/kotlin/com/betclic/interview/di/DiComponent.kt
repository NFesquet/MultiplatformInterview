package com.betclic.interview.di

import org.koin.core.Koin
import org.koin.core.component.KoinComponent
import org.koin.dsl.koinApplication
import org.koin.ksp.generated.module

internal abstract class DiComponent : KoinComponent {

    override fun getKoin(): Koin = IsolatedKoinContext.koin
}

object IsolatedKoinContext {
    val koinApp = koinApplication {
        modules(CommonModule().module)
    }

    val koin = koinApp.koin
}
