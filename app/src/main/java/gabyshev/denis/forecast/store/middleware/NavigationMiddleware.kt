package gabyshev.denis.forecast.store.middleware

import gabyshev.denis.forecast.core.redux.Action
import gabyshev.denis.forecast.core.redux.Middleware
import gabyshev.denis.forecast.core.store.AppState
import gabyshev.denis.forecast.store.OpenSelectCityScreen
import javax.inject.Inject

class NavigationMiddleware @Inject constructor(
) : Middleware<AppState> {

    override fun bind(action: Action, state: AppState, dispatch: (Action) -> Unit) {
        when (action) {
            is OpenSelectCityScreen -> Unit
            else -> Unit
        }
    }
}