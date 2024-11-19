package com.betclic.interview.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.defaultRequest
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.betclic.interview")
class CommonModule {

    @Single(createdAtStart = true)
    @Named("playersUrl")
    fun provideHttpClient(): HttpClient {
        return HttpClient {
            defaultRequest {
                url("https://gbutel-betclic.github.io/Betclic_Interview/api/")
            }
        }
    }
}