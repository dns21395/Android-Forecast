package gabyshev.denis.forecast.core.data.api

import gabyshev.denis.forecast.core.data.api.entity.City

interface CityApi {

    fun getCities(city: String): List<City>
}
