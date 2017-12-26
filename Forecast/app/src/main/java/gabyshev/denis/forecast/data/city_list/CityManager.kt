package gabyshev.denis.forecast.data.city_list

import gabyshev.denis.forecast.data.city_list.model.City


/**
 * Created by denis on 24/12/2017.
 */
interface CityManager {
    fun getCityList(city: String): ArrayList<City>
}