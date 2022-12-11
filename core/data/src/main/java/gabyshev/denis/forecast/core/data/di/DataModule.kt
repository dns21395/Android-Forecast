package gabyshev.denis.forecast.core.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import gabyshev.denis.forecast.core.data.api.CityApi
import gabyshev.denis.forecast.core.data.api.ResourceManagerApi
import gabyshev.denis.forecast.core.data.api.WeatherApi
import gabyshev.denis.forecast.core.data.api.impl.CityImpl
import gabyshev.denis.forecast.core.data.api.impl.ResourceManagerImpl
import gabyshev.denis.forecast.core.data.domain.interactor.WeatherInteractor
import gabyshev.denis.forecast.core.di.PerFeature
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
internal class DataModule(private val context: Context) {

    @PerFeature
    @Provides
    fun provideContext(): Context = context

    @PerFeature
    @Provides
    fun provideCityApi(cityImpl: CityImpl): CityApi = cityImpl

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideWeatherInteractor(interactor: WeatherInteractor): WeatherInteractor = interactor

    @PerFeature
    @Provides
    fun provideResourceManagerApi(
        resourceManagerImpl: ResourceManagerImpl,
    ): ResourceManagerApi {
        return resourceManagerImpl
    }
}
