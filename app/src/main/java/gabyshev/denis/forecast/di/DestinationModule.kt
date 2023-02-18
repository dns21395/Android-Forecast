package gabyshev.denis.forecast.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import gabyshev.denis.forecast.core.common.FeatureEntry
import gabyshev.denis.forecast.core.common.FeatureEntryKey
import gabyshev.denis.forecast.feature.select_city.SelectCityEntry
import gabyshev.denis.forecast.feature.select_city.SelectCityEntryImpl
import javax.inject.Singleton

@Module
interface DestinationModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(SelectCityEntry::class)
    fun provideDestinations(entry: SelectCityEntryImpl): FeatureEntry
}