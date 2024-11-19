package com.betclic.interview.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.ksp.generated.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
    startKoin {
        appDeclaration()
        koinConfiguration()
    }
}

fun koinConfiguration(): KoinApplication.() -> Unit = {
    modules(CommonModule().module)
}
