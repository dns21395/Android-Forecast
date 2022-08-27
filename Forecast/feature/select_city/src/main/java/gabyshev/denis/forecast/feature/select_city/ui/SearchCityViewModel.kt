package gabyshev.denis.forecast.feature.select_city.ui

import androidx.lifecycle.ViewModel
import gabyshev.denis.forecast.feature.select_city.store.SelectCityStore
import javax.inject.Inject

class SearchCityViewModel @Inject constructor(
    private val store: SelectCityStore,
) : ViewModel() {

    init {
        store.wire()
    }
}