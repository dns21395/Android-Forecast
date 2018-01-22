package gabyshev.denis.forecast.ui.city.result

import android.content.Context
import android.util.Log
import gabyshev.denis.forecast.data.DataManager
import gabyshev.denis.forecast.di.ActivityContext
import gabyshev.denis.forecast.ui.base.BasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by denis on 25/12/2017.
 */
class ResultCityPresenter<V: ResultCityMvpView>
    @Inject constructor(@ActivityContext context: Context,
                        dataManager: DataManager,
                        compositeDisposable: CompositeDisposable)
    : BasePresenter<V>(context, dataManager, compositeDisposable), ResultCityMvpPresenter<V> {

    private val TAG = "ResultCityPresenter"

    override fun updateUserCity(city: Long) {
        compositeDisposable.add(Observable.fromCallable {
           // Log.d(TAG, "city : $city, dataManagercity : ${dataManager.city}")
            dataManager.setCity(city)
        }       .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe {
            mvpView?.openSplashActivity()
        })
    }
}