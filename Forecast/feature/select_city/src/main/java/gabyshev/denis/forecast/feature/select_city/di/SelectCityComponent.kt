package gabyshev.denis.forecast.feature.select_city.di

import dagger.Component
import gabyshev.denis.forecast.core.common.CoreProvider
import gabyshev.denis.forecast.core.di.PerFeature
import gabyshev.denis.forecast.feature.select_city.ui.SearchCityViewModel

@Component(
    dependencies = [CoreProvider::class],
    modules = [SelectCityModule::class]
)
@PerFeature
interface SelectCityComponent {

    @Component.Builder
    interface Builder {
        fun coreProvider(coreProvider: CoreProvider): Builder
        fun build(): SelectCityComponent
    }

    fun searchCityViewModel(): SearchCityViewModel
}