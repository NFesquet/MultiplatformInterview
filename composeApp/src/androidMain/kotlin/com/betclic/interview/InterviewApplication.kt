package com.betclic.interview

import android.app.Application
import com.betclic.interview.di.AppModuleKoin
import com.betclic.interview.di.initKoin
import com.betclic.interview.home.domain.usecase.GetPlayersUseCase
import com.betclic.interview.ui.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.GlobalContext
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import org.koin.ksp.generated.module

//@HiltAndroidApp(Application::class)
class InterviewApplication : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(this@InterviewApplication)
            modules(AppModuleKoin().module,
                module {
                    factoryOf(::GetPlayersUseCase)
                    viewModel { MainViewModel(get()) }
                }
            )
        }

//        GlobalContext.startKoin {
//            modules(AppModuleKoin().module,
//                module {
//                    factoryOf(::GetPlayersUseCase)
//                    viewModel { MainViewModel(get()) }
//                }
//            )
//        }

//        initKoin()
    }
}