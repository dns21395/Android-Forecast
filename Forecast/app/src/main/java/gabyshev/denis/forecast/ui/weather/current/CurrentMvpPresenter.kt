package gabyshev.denis.forecast.ui.weather.current

import gabyshev.denis.forecast.ui.base.MvpPresenter

/**
 * Created by denis on 26/12/2017.
 */
interface CurrentMvpPresenter<V: CurrentMvpView> : MvpPresenter<V> {
    fun getTodayWeather()
}