package gabyshev.denis.forecast.store.middleware

import com.github.terrakok.modo.Forward
import com.github.terrakok.modo.Modo
import gabyshev.denis.forecast.Screen
import gabyshev.denis.forecast.core.redux.Action
import gabyshev.denis.forecast.core.redux.Middleware
import gabyshev.denis.forecast.core.store.AppState
import gabyshev.denis.forecast.store.OpenSelectCityScreen
import javax.inject.Inject

class NavigationMiddleware @Inject constructor(
    private val modo: Modo
) : Middleware<AppState> {

    override fun bind(action: Action, state: AppState, dispatch: (Action) -> Unit) {
        when (action) {
            is OpenSelectCityScreen -> modo.dispatch(Forward(Screen.SelectCity()))
            else -> Unit
        }
    }
}