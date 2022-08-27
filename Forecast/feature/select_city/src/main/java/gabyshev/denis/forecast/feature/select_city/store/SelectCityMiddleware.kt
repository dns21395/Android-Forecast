package gabyshev.denis.forecast.feature.select_city.store

import gabyshev.denis.forecast.core.redux.Action
import gabyshev.denis.forecast.core.redux.Middleware
import javax.inject.Inject

class SelectCityMiddleware @Inject constructor() : Middleware<SelectCityState> {

    override fun bind(action: Action, state: SelectCityState, dispatch: (Action) -> Unit) {
        when (action) {
            is OnCityNameEntered -> dispatch(OnCitiesFound)
        }
    }
}