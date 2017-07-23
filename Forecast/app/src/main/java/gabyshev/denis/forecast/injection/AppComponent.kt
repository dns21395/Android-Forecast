package gabyshev.denis.forecast.injection

import dagger.Component
import gabyshev.denis.forecast.App
import gabyshev.denis.forecast.main.MainActivity
import gabyshev.denis.forecast.city.result.ResultFragment
import gabyshev.denis.forecast.city.search.SearchFragment
import gabyshev.denis.forecast.city.search.SearchHelper
import gabyshev.denis.forecast.main.CurrentFragment
import javax.inject.Singleton

/**
 * Created by Borya on 22.07.2017.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class))
interface AppComponent {
    fun inject(app: App)
    fun inject(cityUtils: SearchHelper)
    fun inject(resultFragment: ResultFragment)
    fun inject(searchFragment: SearchFragment)
    fun inject(currentFragment: CurrentFragment)

}