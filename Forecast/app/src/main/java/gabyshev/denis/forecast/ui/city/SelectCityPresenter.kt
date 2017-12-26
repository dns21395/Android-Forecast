package gabyshev.denis.forecast.ui.city

import android.content.Context
import gabyshev.denis.forecast.data.DataManager
import gabyshev.denis.forecast.data.city_list.CityManager
import gabyshev.denis.forecast.data.city_list.model.City
import gabyshev.denis.forecast.di.ActivityContext
import gabyshev.denis.forecast.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by denis on 24/12/2017.
 */
class SelectCityPresenter<V: SelectCityMvpView>
    @Inject constructor(@ActivityContext context: Context,
                        dataManager: DataManager,
                        compositeDisposable: CompositeDisposable)
    : BasePresenter<V>(context, dataManager, compositeDisposable), SelectCityMvpPresenter<V> {

    var arrayCities = ArrayList<City>()

    override fun setCities(cities: ArrayList<City>) {
        arrayCities.clear()
        arrayCities = cities
    }

    override fun getCities(): ArrayList<City> = arrayCities




}