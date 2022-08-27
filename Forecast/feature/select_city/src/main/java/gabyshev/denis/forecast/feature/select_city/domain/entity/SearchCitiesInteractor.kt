package gabyshev.denis.forecast.feature.select_city.domain.entity

import gabyshev.denis.forecast.core.data.api.CityApi
import gabyshev.denis.forecast.core.data.api.entity.City
import javax.inject.Inject

class SearchCitiesInteractor @Inject constructor(
    private val cityApi: CityApi,
) {
    fun searchCities(cityName: String): List<City> = cityApi.getCities(cityName)
}