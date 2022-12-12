package gabyshev.denis.forecast.ui

import androidx.compose.runtime.Composable
import com.github.terrakok.modo.stack.StackScreen

class AppNavigation {

    private var rootScreen: StackScreen? = null

    fun setup(stack: StackScreen) {
        rootScreen = stack
    }

    fun getStack(): StackScreen? = rootScreen

    @Composable
    fun Content() = rootScreen!!.Content()
}