package uk.nightlines.navigation

import kotlinx.coroutines.flow.MutableStateFlow

class NavigationManager {

    val commands = MutableStateFlow(Directions.Default)

    fun navigate(
        directions: NavigationCommand
    ) {
        commands.value = directions
    }
}