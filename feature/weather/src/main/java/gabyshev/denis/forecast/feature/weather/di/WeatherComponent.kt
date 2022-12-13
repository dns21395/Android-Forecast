package gabyshev.denis.forecast.feature.weather.di

import dagger.Component
import gabyshev.denis.forecast.core.common.CoreProvider
import gabyshev.denis.forecast.core.di.PerFeature
import gabyshev.denis.forecast.feature.weather.WeatherViewModel

@Component(
    dependencies = [CoreProvider::class],
    modules = [WeatherModule::class]
)
@PerFeature
interface WeatherComponent {

    @Component.Builder
    interface Builder {
        fun coreProvider(coreProvider: CoreProvider): Builder
        fun build(): WeatherComponent
    }

    fun viewModel(): WeatherViewModel
}