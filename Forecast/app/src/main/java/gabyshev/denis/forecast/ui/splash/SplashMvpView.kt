package gabyshev.denis.forecast.ui.splash

import gabyshev.denis.forecast.ui.base.MvpView

/**
 * Created by denis on 24/12/2017.
 */
interface SplashMvpView : MvpView {
    fun openSelectCityActivity()

    fun openWeatherActivity()
}