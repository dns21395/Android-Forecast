package gabyshev.denis.forecast.feature.select_city.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gabyshev.denis.forecast.core.data.api.ResourceManagerApi
import gabyshev.denis.forecast.core.data.api.entity.City
import gabyshev.denis.forecast.core.navigation.Navigation
import gabyshev.denis.forecast.core.navigation.NavigationCommand
import gabyshev.denis.forecast.feature.select_city.R
import gabyshev.denis.forecast.feature.select_city.di.SelectCityNavigationQualifier
import gabyshev.denis.forecast.feature.select_city.domain.entity.ScreenType
import gabyshev.denis.forecast.feature.select_city.domain.interactor.SearchCitiesInteractor
import gabyshev.denis.forecast.feature.select_city.store.SelectCityState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class SelectCityViewModel @Inject constructor(
    private val searchCitiesInteractor: SearchCitiesInteractor,
    private val resourceManagerApi: ResourceManagerApi,
    @SelectCityNavigationQualifier private val selectCityNavigation: Navigation
) : ViewModel() {

    val navigationCommands: Flow<NavigationCommand> = selectCityNavigation.commandsFlow

    val state = MutableStateFlow(SelectCityState())

    private val _toastMessage = MutableSharedFlow<String>()
    val toastMessage = _toastMessage.asSharedFlow()

    fun onCitySelected(city: City) {
        searchCitiesInteractor.saveCity(city)
        // TODO open next screen
    }

    fun onDoneButtonClicked(cityName: String) {
        // TODO IO
        viewModelScope.launch {
            val cities = searchCitiesInteractor.searchCities(cityName)
            if (cities.isNotEmpty()) {
                state.update {
                    it.copy(
                        currentScreen = ScreenType.FOUND_CITIES,
                        cities = cities
                    )
                }
            } else {
                _toastMessage.emit(resourceManagerApi.getString(R.string.city_not_found))
            }
        }

    }
}