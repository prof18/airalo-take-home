package com.prof18.airalo

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class AiraloApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (com.prof18.airalo.BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            // Log to Crashalytics
        }

        startKoin {
            allowOverride(true)
            androidContext(this@AiraloApp)
            modules(airaloAppModule)
        }
    }
}
