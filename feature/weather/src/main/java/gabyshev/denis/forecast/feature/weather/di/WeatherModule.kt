package gabyshev.denis.forecast.feature.weather.di

import dagger.Module
import dagger.Provides
import gabyshev.denis.forecast.core.data.api.CityApi
import gabyshev.denis.forecast.core.data.di.DataApi
import gabyshev.denis.forecast.core.di.PerFeature
import gabyshev.denis.forecast.core.navigation.Navigation

@Module
class WeatherModule {

    @Provides
    @PerFeature
    fun cityApi(dataApi: DataApi): CityApi = dataApi.cityApi()

    @Provides
    @PerFeature
    @WeatherNavigationQualifier
    fun navigation(): Navigation = Navigation()

}