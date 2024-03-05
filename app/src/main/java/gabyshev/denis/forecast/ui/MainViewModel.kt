package gabyshev.denis.forecast.ui

import androidx.lifecycle.ViewModel
import gabyshev.denis.forecast.core.navigation.Navigation
import gabyshev.denis.forecast.core.navigation.NavigationCommand
import gabyshev.denis.forecast.core.navigation.RootNavigationQualifier
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainViewModel @Inject constructor(
    @RootNavigationQualifier private val rootNavigation: Navigation
) : ViewModel() {

    val navigationCommands: Flow<NavigationCommand> = rootNavigation.commandsFlow

}