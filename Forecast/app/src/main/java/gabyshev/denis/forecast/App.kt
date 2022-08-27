package gabyshev.denis.forecast

import android.app.Application
import gabyshev.denis.forecast.di.AppApi
import gabyshev.denis.forecast.di.AppComponent
import gabyshev.denis.forecast.di.AppModule
import gabyshev.denis.forecast.di.DaggerAppComponent

class App :
    Application(),
    gabyshev.denis.forecast.core.common.ApplicationApi,
    AppApi {

    private val component: AppComponent = DaggerAppComponent
        .builder()
        .appModule(AppModule(this))
        .build()

    override fun getComponent(): AppComponent = component

    override fun coreProvider(): gabyshev.denis.forecast.core.common.CoreProvider = component
}