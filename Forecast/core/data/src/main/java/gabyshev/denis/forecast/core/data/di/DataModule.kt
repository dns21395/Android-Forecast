package gabyshev.denis.forecast.core.data.di

import dagger.Module
import dagger.Provides
import gabyshev.denis.forecast.core.data.api.CityApi
import gabyshev.denis.forecast.core.data.api.impl.CityImpl
import gabyshev.denis.forecast.core.di.PerFeature

@Module
internal class DataModule {

    @PerFeature
    @Provides
    fun provideCityApi(cityImpl: CityImpl): CityApi = cityImpl
}
