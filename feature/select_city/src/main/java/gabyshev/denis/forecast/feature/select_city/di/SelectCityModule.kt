package gabyshev.denis.forecast.feature.select_city.di

import dagger.Module
import dagger.Provides
import gabyshev.denis.forecast.core.data.api.CityApi
import gabyshev.denis.forecast.core.data.api.ResourceManagerApi
import gabyshev.denis.forecast.core.data.di.DataApi
import gabyshev.denis.forecast.core.di.PerFeature
import gabyshev.denis.forecast.core.navigation.Navigation

@Module
class SelectCityModule {

    @Provides
    @PerFeature
    fun cityApi(dataApi: DataApi): CityApi = dataApi.cityApi()

    @Provides
    @PerFeature
    fun provideResourceManagerApi(dataApi: DataApi): ResourceManagerApi =
        dataApi.resourceManagerApi()

    @Provides
    @PerFeature
    @SelectCityNavigationQualifier
    fun provideNavigation(): Navigation = Navigation()
}