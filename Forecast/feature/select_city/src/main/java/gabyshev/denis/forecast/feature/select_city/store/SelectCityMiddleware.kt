package gabyshev.denis.forecast.feature.select_city.store

import gabyshev.denis.forecast.core.redux.Action
import gabyshev.denis.forecast.core.redux.Middleware
import gabyshev.denis.forecast.feature.select_city.domain.entity.SearchCitiesInteractor
import javax.inject.Inject

class SelectCityMiddleware @Inject constructor(
    private val searchCitiesInteractor: SearchCitiesInteractor,
) : Middleware<SelectCityState> {

    override fun bind(action: Action, state: SelectCityState, dispatch: (Action) -> Unit) {
        when (action) {
            is OnCityNameEntered -> {
                val cities = searchCitiesInteractor.searchCities(action.cityName)
                dispatch(OnCitiesFound(cities))
            }
        }
    }
}