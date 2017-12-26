package gabyshev.denis.forecast.ui.city.search

import gabyshev.denis.forecast.data.city_list.CityManager
import gabyshev.denis.forecast.data.city_list.model.City
import gabyshev.denis.forecast.di.PerFragment
import gabyshev.denis.forecast.ui.base.MvpPresenter

/**
 * Created by denis on 24/12/2017.
 */
interface SearchCityMvpPresenter<V : SearchCityMvpView> : MvpPresenter<V> {
    fun getCityList(city: String)

}