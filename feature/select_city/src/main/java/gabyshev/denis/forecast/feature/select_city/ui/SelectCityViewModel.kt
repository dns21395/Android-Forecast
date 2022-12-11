package gabyshev.denis.forecast.feature.select_city.ui

import androidx.lifecycle.ViewModel
import gabyshev.denis.forecast.core.data.api.entity.City
import gabyshev.denis.forecast.feature.select_city.store.OnCityClicked
import gabyshev.denis.forecast.feature.select_city.store.OnCityNameEntered
import gabyshev.denis.forecast.feature.select_city.store.SelectCityStore
import javax.inject.Inject

class SelectCityViewModel @Inject constructor(
    private val store: SelectCityStore,
) : ViewModel() {

    val uiState = store.state

    init {
        store.wire()
    }

    fun onCitySelected(city: City) {
        store.dispatch(OnCityClicked(city))
    }

    fun onDoneButtonClicked(cityName: String) {
        store.dispatch(OnCityNameEntered(cityName))
    }
}