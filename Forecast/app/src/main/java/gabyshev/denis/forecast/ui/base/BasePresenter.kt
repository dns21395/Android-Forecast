package gabyshev.denis.forecast.ui.base

import android.content.Context
import gabyshev.denis.forecast.data.DataManager
import gabyshev.denis.forecast.di.ActivityContext
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by denis on 24/12/2017.
 */
open class BasePresenter<V: MvpView>
    @Inject constructor(val context: Context,
                        val dataManager: DataManager,
                        val compositeDisposable: CompositeDisposable): MvpPresenter<V> {
    var mvpView: V? = null

    override fun onAttach(mvpView: V) {
        this.mvpView = mvpView
    }

    override fun onDetach() {
        compositeDisposable.dispose()
        mvpView = null
    }
}