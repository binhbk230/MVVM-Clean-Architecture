package com.bstudio

import android.app.Application
import com.bstudio.androidtemplate.di.appModule
import com.bstudio.di.databaseModule
import com.bstudio.di.networkModule
import com.bstudio.di.repositoryModule
import com.bstudio.domain.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(appModule, useCaseModule, repositoryModule, networkModule, databaseModule))
        }
    }
}