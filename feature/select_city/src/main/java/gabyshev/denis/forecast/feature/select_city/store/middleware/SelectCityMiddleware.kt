package gabyshev.denis.forecast.feature.select_city.store.middleware

import gabyshev.denis.forecast.core.common.store.OpenSelectCityScreen
import gabyshev.denis.forecast.core.common.store.ShowToastAction
import gabyshev.denis.forecast.core.data.api.ResourceManagerApi
import gabyshev.denis.forecast.core.redux.Action
import gabyshev.denis.forecast.core.redux.Middleware
import gabyshev.denis.forecast.feature.select_city.R
import gabyshev.denis.forecast.feature.select_city.domain.interactor.SearchCitiesInteractor
import gabyshev.denis.forecast.feature.select_city.store.OnCitiesFound
import gabyshev.denis.forecast.feature.select_city.store.OnCityClicked
import gabyshev.denis.forecast.feature.select_city.store.OnCityNameEntered
import gabyshev.denis.forecast.feature.select_city.store.SelectCityState
import javax.inject.Inject

class SelectCityMiddleware @Inject constructor(
    private val searchCitiesInteractor: SearchCitiesInteractor,
    private val resourceManagerApi: ResourceManagerApi
) : Middleware<SelectCityState> {

    override suspend fun bind(action: Action, state: SelectCityState, dispatch: (Action) -> Unit) {
        when (action) {
            is OnCityNameEntered -> {
                val cities = searchCitiesInteractor.searchCities(action.cityName)
                if (cities.isNotEmpty()) {
                    dispatch(OnCitiesFound(cities))
                } else {
                    dispatch(ShowToastAction(resourceManagerApi.getString(R.string.city_not_found)))
                }
            }
            is OnCityClicked -> {
                searchCitiesInteractor.saveCity(action.city)
                dispatch(OpenSelectCityScreen)
            }
        }
    }
}