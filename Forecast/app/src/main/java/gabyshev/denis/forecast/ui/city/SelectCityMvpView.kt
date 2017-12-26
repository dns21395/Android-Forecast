package gabyshev.denis.forecast.ui.city

import gabyshev.denis.forecast.ui.base.MvpView

/**
 * Created by denis on 24/12/2017.
 */
interface SelectCityMvpView : MvpView {
    fun setViewPagerPage(page: Int)

    fun openSplashActivity()
}