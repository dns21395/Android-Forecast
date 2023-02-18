package gabyshev.denis.forecast.di

import dagger.Component
import gabyshev.denis.forecast.core.common.CoreProvider
import gabyshev.denis.forecast.core.common.Destinations
import gabyshev.denis.forecast.ui.MainActivity
import gabyshev.denis.forecast.ui.MainViewModel
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class,
        DestinationModule::class
    ]
)
@Singleton
interface AppComponent : CoreProvider {

    val destinations: Destinations

    fun inject(activity: MainActivity)
    fun mainViewModel(): MainViewModel
}
