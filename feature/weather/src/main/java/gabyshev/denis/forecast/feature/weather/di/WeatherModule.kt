package gabyshev.denis.forecast.feature.weather.di

import dagger.Module
import dagger.Provides
import gabyshev.denis.forecast.core.data.api.CityApi
import gabyshev.denis.forecast.core.data.di.DataApi
import gabyshev.denis.forecast.core.di.PerFeature
import gabyshev.denis.forecast.core.store.AppStore
import gabyshev.denis.forecast.feature.weather.store.WeatherState
import gabyshev.denis.forecast.feature.weather.store.WeatherStore
import gabyshev.denis.forecast.feature.weather.store.reduce

@Module
class WeatherModule {

    @Provides
    @PerFeature
    fun provideStore(
        appStore: AppStore,
    ): WeatherStore {
        return appStore.scope(
            initialState = WeatherState(),
            reducer = WeatherState::reduce
        )
    }

    @Provides
    @PerFeature
    fun cityApi(dataApi: DataApi): CityApi = dataApi.cityApi()

}