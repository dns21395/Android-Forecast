package gabyshev.denis.forecast.ui.weather.tomorrow

import gabyshev.denis.forecast.ui.base.MvpPresenter

/**
 * Created by denis on 26/12/2017.
 */
interface TomorrowMvpPresenter<V: TomorrowMvpView> : MvpPresenter<V> {
    fun getTomorrowWeather()
}