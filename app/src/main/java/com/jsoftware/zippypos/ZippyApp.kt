package com.jsoftware.zippypos

import android.app.Application
import com.jsoftware.zippypos.domain.di.appModule
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ZippyApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            modules(appModule)
        }

    }
}