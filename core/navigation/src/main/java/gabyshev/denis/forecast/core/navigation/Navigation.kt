package gabyshev.denis.forecast.core.navigation

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

class Navigation {

    private val _commandsFlow = Channel<NavigationCommand>()

    val commandsFlow: Flow<NavigationCommand> = _commandsFlow.receiveAsFlow()

    suspend fun navigate(command: NavigationCommand) {
        _commandsFlow.send(command)
    }
}