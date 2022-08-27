package gabyshev.denis.forecast.feature.select_city.di

import dagger.Component
import gabyshev.denis.forecast.core.di.CoreProvider
import gabyshev.denis.forecast.core.di.PerFeature

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

}