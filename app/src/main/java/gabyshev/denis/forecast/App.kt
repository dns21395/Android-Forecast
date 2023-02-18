package gabyshev.denis.forecast

import android.app.Application
import gabyshev.denis.forecast.core.common.AppDependenciesProvider
import gabyshev.denis.forecast.core.common.CoreProvider
import gabyshev.denis.forecast.core.common.Destinations
import gabyshev.denis.forecast.di.AppApi
import gabyshev.denis.forecast.di.AppComponent
import gabyshev.denis.forecast.di.AppModule
import gabyshev.denis.forecast.di.DaggerAppComponent

class App :
    Application(),
    gabyshev.denis.forecast.core.common.ApplicationApi,
    AppApi,
    AppDependenciesProvider {

    private val component: AppComponent = DaggerAppComponent
        .builder()
        .appModule(AppModule(this))
        .build()

    override fun getComponent(): AppComponent = component

    override fun coreProvider(): CoreProvider = component

    override val destinations: Destinations = component.destinations
}