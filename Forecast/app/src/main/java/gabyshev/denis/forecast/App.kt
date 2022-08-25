package gabyshev.denis.forecast

import android.app.Application
import gabyshev.denis.forecast.core.di.ApplicationApi
import gabyshev.denis.forecast.core.di.CoreProvider
import gabyshev.denis.forecast.di.AppComponent
import gabyshev.denis.forecast.di.AppModule
import gabyshev.denis.forecast.di.DaggerAppComponent

class App : Application(), ApplicationApi {

    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun coreProvider(): CoreProvider = component as CoreProvider
}