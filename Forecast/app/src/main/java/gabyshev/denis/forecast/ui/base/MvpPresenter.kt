package gabyshev.denis.forecast.ui.base

/**
 * Created by denis on 24/12/2017.
 */
interface MvpPresenter<V: MvpView> {
    fun onAttach(mvpView: V)

    fun onDetach()
}