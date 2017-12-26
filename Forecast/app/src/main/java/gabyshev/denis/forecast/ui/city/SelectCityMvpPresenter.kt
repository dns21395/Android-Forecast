package gabyshev.denis.forecast.ui.city

import gabyshev.denis.forecast.data.city_list.CityManager
import gabyshev.denis.forecast.data.city_list.model.City
import gabyshev.denis.forecast.di.PerActivity
import gabyshev.denis.forecast.ui.base.MvpPresenter

/**
 * Created by denis on 24/12/2017.
 */
@PerActivity
interface SelectCityMvpPresenter<V: SelectCityMvpView> : MvpPresenter<V> {
    fun setCities(cities: ArrayList<City>)

    fun getCities(): ArrayList<City>
}