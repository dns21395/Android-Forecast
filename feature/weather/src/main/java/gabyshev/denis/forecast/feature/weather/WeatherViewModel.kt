package gabyshev.denis.forecast.feature.weather

import androidx.lifecycle.ViewModel
import gabyshev.denis.forecast.core.navigation.Navigation
import gabyshev.denis.forecast.core.navigation.NavigationCommand
import gabyshev.denis.forecast.feature.weather.di.WeatherNavigationQualifier
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherViewModel @Inject constructor(
    @WeatherNavigationQualifier private val weatherNavigation: Navigation
) : ViewModel() {

    val navigationCommands: Flow<NavigationCommand> = weatherNavigation.commandsFlow


}