package gabyshev.denis.forecast.weather_week.di

import dagger.Module
import dagger.Provides
import gabyshev.denis.forecast.core.data.api.CityApi
import gabyshev.denis.forecast.core.data.api.interactor.WeekInteractor
import gabyshev.denis.forecast.core.data.di.DataApi
import gabyshev.denis.forecast.core.di.PerFeature
import gabyshev.denis.forecast.core.store.AppStore
import gabyshev.denis.forecast.weather_week.store.WeekState
import gabyshev.denis.forecast.weather_week.store.WeekStore
import gabyshev.denis.forecast.weather_week.store.middleware.WeekMiddleware
import gabyshev.denis.forecast.weather_week.store.reduce

@Module
internal class WeekModule {

    @Provides
    @PerFeature
    fun provideStore(
        appStore: AppStore,
        weekMiddleware: WeekMiddleware
    ): WeekStore {
        return appStore.scope(
            initialState = WeekState(),
            reducer = WeekState::reduce,
            middlewares = listOf(weekMiddleware)
        )
    }

    @Provides
    @PerFeature
    fun cityApi(dataApi: DataApi): CityApi = dataApi.cityApi()

    @Provides
    @PerFeature
    fun weatherApi(dataApi: DataApi): WeekInteractor = dataApi.weekInteractor()
}