package gabyshev.denis.forecast.feature.weather.di

import dagger.Module
import dagger.Provides
import gabyshev.denis.forecast.core.data.api.CityApi
import gabyshev.denis.forecast.core.data.di.DataApi
import gabyshev.denis.forecast.core.di.PerFeature

@Module
class WeatherModule {

    @Provides
    @PerFeature
    fun cityApi(dataApi: DataApi): CityApi = dataApi.cityApi()

}