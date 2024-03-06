package gabyshev.denis.forecast.feature.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gabyshev.denis.forecast.core.navigation.Navigation
import gabyshev.denis.forecast.core.navigation.NavigationCommand
import gabyshev.denis.forecast.core.navigation.NavigationReplace
import gabyshev.denis.forecast.feature.weather.di.WeatherNavigationQualifier
import gabyshev.denis.forecast.weather_day.ui.WeekScreen
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherViewModel @Inject constructor(
    @WeatherNavigationQualifier private val weatherNavigation: Navigation
) : ViewModel() {

    init {
        viewModelScope.launch {
            weatherNavigation.navigate(NavigationReplace(WeekScreen()))
        }
    }

    val navigationCommands: Flow<NavigationCommand> = weatherNavigation.commandsFlow
}