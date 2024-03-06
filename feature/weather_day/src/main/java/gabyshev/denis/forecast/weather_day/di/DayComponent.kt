package gabyshev.denis.forecast.weather_day.di

import dagger.Component
import gabyshev.denis.forecast.core.common.CoreProvider
import gabyshev.denis.forecast.weather_day.ui.DayViewModel

@Component(
    dependencies = [CoreProvider::class],
)
internal interface DayComponent {

    @Component.Factory
    interface Builder {
        fun create(coreProvider: CoreProvider): DayComponent
    }

    fun viewModel(): DayViewModel
}