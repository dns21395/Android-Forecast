package gabyshev.denis.forecast.weather_week.di

import dagger.Component
import gabyshev.denis.forecast.core.common.CoreProvider
import gabyshev.denis.forecast.core.di.PerFeature
import gabyshev.denis.forecast.weather_week.ui.WeekViewModel

@Component(
    dependencies = [CoreProvider::class],
    modules = [WeekModule::class]
)
@PerFeature
internal interface WeekComponent {

    fun viewModel(): WeekViewModel
}