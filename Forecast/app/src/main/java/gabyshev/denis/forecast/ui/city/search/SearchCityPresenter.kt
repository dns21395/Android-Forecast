package gabyshev.denis.forecast.ui.city.search

import android.content.Context
import gabyshev.denis.forecast.R
import gabyshev.denis.forecast.data.DataManager
import gabyshev.denis.forecast.data.city_list.CityManager
import gabyshev.denis.forecast.di.ActivityContext
import gabyshev.denis.forecast.di.PerFragment
import gabyshev.denis.forecast.ui.base.BasePresenter
import gabyshev.denis.forecast.ui.city.result.ResultCityAdapter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by denis on 24/12/2017.
 */
class SearchCityPresenter<V : SearchCityMvpView>
@Inject constructor(@ActivityContext context: Context,
                    dataManager: DataManager,
                    compositeDisposable: CompositeDisposable,
                    val cityManager: CityManager,
                    val resultCityAdapter: ResultCityAdapter)
    : BasePresenter<V>(context, dataManager, compositeDisposable), SearchCityMvpPresenter<V> {

    private val TAG = "SearchCityPresenter"

    override fun getCityList(city: String) {
        compositeDisposable.add(
                Observable.fromCallable {
                    cityManager.getCityList(city)
                }.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            mvpView?.stopSearchAnimation()
                            when(it.size) {
                                0 -> mvpView?.showMessage(context.getString(R.string.city_not_found))
                                else -> {
                                    resultCityAdapter.updateCities(it)
                                    mvpView?.moveToNextPage()
                                }
                            }
                        }
        )

    }
}