package gabyshev.denis.forecast.di.module

import dagger.Module
import dagger.Provides
import gabyshev.denis.forecast.data.network.RetrofitWeatherService
import gabyshev.denis.forecast.data.network.WeatherService
import gabyshev.denis.forecast.data.prefs.AppPreferencesHelper
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Borya on 23.07.2017.
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideWeatherService(retrofit: Retrofit): WeatherService {
        return retrofit.create(WeatherService::class.java)
    }

    @Provides
    @Singleton
    fun provideService(weatherService: WeatherService, appPreferencesHelper: AppPreferencesHelper): RetrofitWeatherService {
        return RetrofitWeatherService(weatherService, appPreferencesHelper)
    }
}