package gabyshev.denis.forecast.store.middleware

import gabyshev.denis.forecast.core.redux.Action
import gabyshev.denis.forecast.core.redux.Middleware
import gabyshev.denis.forecast.core.store.AppState
import javax.inject.Inject

class NavigationMiddleware @Inject constructor(
) : Middleware<AppState> {

    override suspend fun bind(action: Action, state: AppState, dispatch: (Action) -> Unit) {

    }
}