package gabyshev.denis.forecast.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import gabyshev.denis.forecast.core.common.FeatureEntry
import gabyshev.denis.forecast.core.common.FeatureEntryKey
import gabyshev.denis.forecast.feature.select_city.SelectCityEntry
import gabyshev.denis.forecast.feature.select_city.SelectCityEntryImpl
import gabyshev.denis.forecast.feature.weather.WeatherEntry
import gabyshev.denis.forecast.feature.weather.WeatherEntryImpl
import javax.inject.Singleton

@Module
interface DestinationModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(SelectCityEntry::class)
    fun provideDestinations(entry: SelectCityEntryImpl): FeatureEntry

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(WeatherEntry::class)
    fun provideWeatherEntry(entry: WeatherEntryImpl): FeatureEntry
}