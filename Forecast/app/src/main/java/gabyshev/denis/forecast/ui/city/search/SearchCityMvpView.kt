package gabyshev.denis.forecast.ui.city.search

import gabyshev.denis.forecast.ui.base.MvpView

/**
 * Created by denis on 24/12/2017.
 */
interface SearchCityMvpView : MvpView {
    fun startSearchAnimation()

    fun stopSearchAnimation()

    fun searchUserCity()

    fun moveToNextPage()
}