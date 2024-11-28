package com.betclic.androidinterview

import android.app.Application
import com.betclic.interview.di.SharedModule
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ExerciseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SharedModule.init(this)
    }
}