package org.densis.weather

import android.app.Application
import org.densis.weather.di.initKoin
import org.koin.android.ext.koin.androidContext

class SelectCityApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@SelectCityApplication)
        }
    }
}