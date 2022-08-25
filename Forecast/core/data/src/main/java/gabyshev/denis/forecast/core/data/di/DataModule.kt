package gabyshev.denis.forecast.core.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import gabyshev.denis.forecast.core.data.api.CityApi
import gabyshev.denis.forecast.core.data.impl.CityImpl
import gabyshev.denis.forecast.core.di.PerFeature

@Module
internal class DataModule(context: Context) {

    @PerFeature
    @Provides
    fun provideCityApi(cityImpl: CityImpl): CityApi = cityImpl
}
