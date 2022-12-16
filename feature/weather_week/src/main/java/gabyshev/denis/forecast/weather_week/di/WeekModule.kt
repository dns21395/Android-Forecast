package gabyshev.denis.forecast.weather_week.di

import dagger.Module
import dagger.Provides
import gabyshev.denis.forecast.core.data.api.CityApi
import gabyshev.denis.forecast.core.data.di.DataApi
import gabyshev.denis.forecast.core.di.PerFeature
import gabyshev.denis.forecast.core.store.AppStore
import gabyshev.denis.forecast.weather_week.store.WeekState
import gabyshev.denis.forecast.weather_week.store.WeekStore
import gabyshev.denis.forecast.weather_week.store.reduce

@Module
internal class WeekModule {

    @Provides
    @PerFeature
    fun provideStore(
        appStore: AppStore,
    ): WeekStore {
        return appStore.scope(
            initialState = WeekState(),
            reducer = WeekState::reduce
        )
    }

    @Provides
    @PerFeature
    fun cityApi(dataApi: DataApi): CityApi = dataApi.cityApi()
}