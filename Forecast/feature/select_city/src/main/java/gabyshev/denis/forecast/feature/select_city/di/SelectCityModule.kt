package gabyshev.denis.forecast.feature.select_city.di

import dagger.Module
import dagger.Provides
import gabyshev.denis.forecast.core.di.PerFeature
import gabyshev.denis.forecast.core.store.AppStore
import gabyshev.denis.forecast.feature.select_city.store.SelectCityState
import gabyshev.denis.forecast.feature.select_city.store.SelectCityStore
import gabyshev.denis.forecast.feature.select_city.store.reduce

@Module
class SelectCityModule {

    @Provides
    @PerFeature
    fun provideStore(appStore: AppStore): SelectCityStore {
        return appStore.scope(
            initialState = SelectCityState(),
            reducer = SelectCityState::reduce
        )
    }
}