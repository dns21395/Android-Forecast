package gabyshev.denis.forecast.core.navigation

import com.github.terrakok.modo.NavigationContainer
import com.github.terrakok.modo.stack.*

fun NavigationContainer<StackState>.navigate(command: NavigationCommand) {
    val action = when (command) {
        is NavigationSetStack -> SetStack(StackState(stack = command.screens))
        is NavigationForward -> Forward(command.screen, *command.screens.toTypedArray())
        is NavigationReplace -> Replace(command.screen, *command.screens.toTypedArray())
        is NavigationNewStack -> NewStack(command.screen, *command.screens.toTypedArray())
        is NavigationBackTo -> BackTo(command.screen)
        is NavigationBackToRoot -> BackToRoot
        is NavigationBack -> Back
        is NavigationRemoveScreen -> RemoveScreens(*command.positions.toIntArray())
        is NavigationExit -> Exit
        else -> throw java.lang.Exception("Wrong Action")
    }
    dispatch(action)
}