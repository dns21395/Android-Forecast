package gabyshev.denis.forecast.core.common

import com.github.terrakok.modo.NavigationContainer
import com.github.terrakok.modo.stack.StackScreen
import com.github.terrakok.modo.stack.StackState

class Navigation {

    private var stackScreen: StackScreen? = null

    fun setContainer(stackScreen: StackScreen) {
        this.stackScreen = stackScreen
    }

    fun getContainer(): StackScreen? = stackScreen

    fun getNavigation(): NavigationContainer<StackState> = stackScreen!!
}