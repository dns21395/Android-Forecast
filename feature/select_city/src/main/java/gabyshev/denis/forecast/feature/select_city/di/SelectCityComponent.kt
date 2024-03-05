package gabyshev.denis.forecast.feature.select_city.di

import dagger.Component
import gabyshev.denis.forecast.core.common.CoreProvider
import gabyshev.denis.forecast.core.di.PerFeature
import gabyshev.denis.forecast.feature.select_city.ui.SelectCityViewModel

@Component(
    dependencies = [CoreProvider::class],
    modules = [SelectCityModule::class]
)
@PerFeature
interface SelectCityComponent {

    @Component.Factory
    interface Builder {
        fun create(coreProvider: CoreProvider): SelectCityComponent
    }

    fun selectCityViewModel(): SelectCityViewModel
}