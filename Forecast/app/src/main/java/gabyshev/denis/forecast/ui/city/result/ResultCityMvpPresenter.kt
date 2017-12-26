package gabyshev.denis.forecast.ui.city.result

import gabyshev.denis.forecast.di.PerFragment
import gabyshev.denis.forecast.ui.base.MvpPresenter

/**
 * Created by denis on 25/12/2017.
 */
interface ResultCityMvpPresenter<V: ResultCityMvpView> : MvpPresenter<V> {
    fun updateUserCity(city: Long)
}