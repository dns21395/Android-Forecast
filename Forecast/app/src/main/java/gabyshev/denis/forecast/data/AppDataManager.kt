package gabyshev.denis.forecast.data

import android.content.Context
import gabyshev.denis.forecast.data.prefs.PreferencesHelper
import gabyshev.denis.forecast.di.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by denis on 24/12/2017.
 */
@Singleton
class AppDataManager
    @Inject constructor(@ApplicationContext private val context: Context,
                        private val preferencesHelper: PreferencesHelper)
    : DataManager {
    override fun setCity(city: Long) {
        preferencesHelper.setCity(city)
    }

    override fun getCity(): Long = preferencesHelper.getCity()

//    override var city : Long
//        get() = preferencesHelper.city
//
//        set(value) {
//            preferencesHelper.city = city
//        }



}