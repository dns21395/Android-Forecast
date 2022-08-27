package gabyshev.denis.forecast.core.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import gabyshev.denis.forecast.core.data.api.CityApi
import gabyshev.denis.forecast.core.data.api.impl.CityImpl
import gabyshev.denis.forecast.core.di.PerFeature

@Module
internal class DataModule(private val context: Context) {

    @PerFeature
    @Provides
    fun provideContext(): Context = context

    @PerFeature
    @Provides
    fun provideCityApi(cityImpl: CityImpl): CityApi = cityImpl
}
