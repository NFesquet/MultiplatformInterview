package com.betclic.interview.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
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
            // Had to add this because API is currently served with a GitHub Pages URL
            // and response has Content-Type "test/html" instead of "application/json"
            install(ContentNegotiation) {
                json(contentType = ContentType.Any)
            }
            defaultRequest {
                url("https://gbutel-betclic.github.io/Betclic_Interview/api/")
                contentType(ContentType.Application.Json)
            }
        }
    }
}