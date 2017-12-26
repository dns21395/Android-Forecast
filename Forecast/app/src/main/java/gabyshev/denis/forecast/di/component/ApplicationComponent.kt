package gabyshev.denis.forecast.di.component

import android.app.Application
import android.content.Context
import dagger.Component
import gabyshev.denis.forecast.App
import gabyshev.denis.forecast.data.AppDataManager
import gabyshev.denis.forecast.data.DataManager
import gabyshev.denis.forecast.di.ApplicationContext
import gabyshev.denis.forecast.di.module.ApplicationModule
import gabyshev.denis.forecast.di.module.NetworkModule
import gabyshev.denis.forecast.data.network.RetrofitWeatherService
import gabyshev.denis.forecast.data.network.WeatherService
import gabyshev.denis.forecast.data.prefs.AppPreferencesHelper
import gabyshev.denis.forecast.data.prefs.PreferencesHelper
import gabyshev.denis.forecast.data.weather.AppWeatherManager
import gabyshev.denis.forecast.data.weather.WeatherManager
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by denis on 22/12/2017.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, NetworkModule::class))
interface ApplicationComponent {
    fun inject(app: App)

    // ApplicationModule
    @ApplicationContext
    fun provideContext(): Context
    fun provideApplication(): Application
    fun provideDataManager(): DataManager
    fun providePreferencesHelper(): PreferencesHelper
    fun provideWeatherManager(): WeatherManager

    // NetworkModule
    fun provideRetrofit(): Retrofit
    fun provideWeatherService(): WeatherService
    fun provideRetrofitWeatherServiceService(): RetrofitWeatherService


}