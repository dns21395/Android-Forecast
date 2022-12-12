package gabyshev.denis.forecast.core.data.api.impl

import gabyshev.denis.forecast.core.data.api.CityApi
import gabyshev.denis.forecast.core.data.api.entity.City
import gabyshev.denis.forecast.core.data.domain.interactor.CitiesGetter
import gabyshev.denis.forecast.core.data.domain.interactor.UserCity
import javax.inject.Inject

internal class CityImpl @Inject constructor(
    private val citiesGetter: CitiesGetter,
    private val userCity: UserCity,
) : CityApi {

    override fun getCities(city: String): List<City> = citiesGetter.getCities(city)

    override fun saveCity(city: City) {
        userCity.updateCity(city)
    }

    override fun getSelectedCity(): City {
        return userCity.getCity()
    }
}
