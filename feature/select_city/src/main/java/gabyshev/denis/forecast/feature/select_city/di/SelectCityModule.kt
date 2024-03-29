package gabyshev.denis.forecast.feature.select_city.di

import dagger.Module
import dagger.Provides
import gabyshev.denis.forecast.core.data.api.CityApi
import gabyshev.denis.forecast.core.data.api.ResourceManagerApi
import gabyshev.denis.forecast.core.data.di.DataApi
import gabyshev.denis.forecast.core.di.PerFeature
import gabyshev.denis.forecast.core.store.AppStore
import gabyshev.denis.forecast.feature.select_city.store.middleware.SelectCityMiddleware
import gabyshev.denis.forecast.feature.select_city.store.SelectCityState
import gabyshev.denis.forecast.feature.select_city.store.SelectCityStore
import gabyshev.denis.forecast.feature.select_city.store.reduce

@Module
class SelectCityModule {

    @Provides
    @PerFeature
    fun provideStore(
        appStore: AppStore,
        selectCityMiddleware: SelectCityMiddleware,
    ): SelectCityStore {
        return appStore.scope(
            initialState = SelectCityState(),
            reducer = SelectCityState::reduce,
            middlewares = listOf(selectCityMiddleware)
        )
    }

    @Provides
    @PerFeature
    fun cityApi(dataApi: DataApi): CityApi = dataApi.cityApi()

    @Provides
    @PerFeature
    fun provideResourceManagerApi(dataApi: DataApi): ResourceManagerApi =
        dataApi.resourceManagerApi()
}