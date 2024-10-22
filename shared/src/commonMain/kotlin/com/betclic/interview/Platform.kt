package com.betclic.interview

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform