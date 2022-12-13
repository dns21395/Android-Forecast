package gabyshev.denis.forecast.store.middleware

import com.github.terrakok.modo.stack.newStack
import gabyshev.denis.forecast.Weather
import gabyshev.denis.forecast.core.common.Navigation
import gabyshev.denis.forecast.core.common.store.OpenSelectCityScreen
import gabyshev.denis.forecast.core.redux.Action
import gabyshev.denis.forecast.core.redux.Middleware
import gabyshev.denis.forecast.core.store.AppState
import javax.inject.Inject

class NavigationMiddleware @Inject constructor(
    private val navigation: Navigation
) : Middleware<AppState> {

    override fun bind(action: Action, state: AppState, dispatch: (Action) -> Unit) {
        when (action) {
            is OpenSelectCityScreen -> navigation.getNavigation().newStack(Weather())
            else -> Unit
        }
    }
}