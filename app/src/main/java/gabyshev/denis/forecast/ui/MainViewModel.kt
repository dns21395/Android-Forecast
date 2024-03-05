package gabyshev.denis.forecast.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gabyshev.denis.forecast.core.navigation.Navigation
import gabyshev.denis.forecast.core.navigation.NavigationCommand
import gabyshev.denis.forecast.core.navigation.NavigationReplace
import gabyshev.denis.forecast.core.navigation.RootNavigationQualifier
import gabyshev.denis.forecast.feature.weather.WeatherStack
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    @RootNavigationQualifier private val rootNavigation: Navigation
) : ViewModel() {

    val navigationCommands: Flow<NavigationCommand> = rootNavigation.commandsFlow

    init {
        viewModelScope.launch {
            rootNavigation.navigate(NavigationReplace(WeatherStack()))
        }
    }

}