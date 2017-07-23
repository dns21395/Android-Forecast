package gabyshev.denis.forecast.injection

import android.util.Log
import dagger.Module
import dagger.Provides
import gabyshev.denis.forecast.weather_api.RetrofitWeatherService
import gabyshev.denis.forecast.weather_api.WeatherService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

/**
 * Created by Borya on 23.07.2017.
 */
@Module
class NetworkModule {
    private val TAG = "NetworkModule"

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
        Log.d(TAG, "provideNetworkService")
        return retrofit.create(WeatherService::class.java)


    }

    @Provides
    @Singleton
    fun provideService(weatherService: WeatherService): RetrofitWeatherService {
        Log.d(TAG, "provideService")
        return RetrofitWeatherService(weatherService)
    }
}