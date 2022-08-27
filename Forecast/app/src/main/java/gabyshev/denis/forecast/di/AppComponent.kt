package gabyshev.denis.forecast.di

import dagger.Component
import gabyshev.denis.forecast.core.di.CoreProvider
import gabyshev.denis.forecast.ui.MainActivity
import gabyshev.denis.forecast.ui.MainViewModel
import javax.inject.Singleton

@Component(
    modules = [AppModule::class]
)
@Singleton
interface AppComponent : CoreProvider {

    fun inject(activity: MainActivity)
    fun mainViewModel(): MainViewModel
}
