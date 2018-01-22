package gabyshev.denis.forecast.data.prefs

import android.content.Context
import android.content.SharedPreferences
import gabyshev.denis.forecast.di.ApplicationContext
import gabyshev.denis.forecast.di.PreferenceInfo
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by denis on 22/12/2017.
 */
@Singleton
class AppPreferencesHelper
    @Inject constructor(@ApplicationContext private val context: Context,
                        @PreferenceInfo private val prefFileName: String)
    : PreferencesHelper {

    private val PREF_CITY = "PREF_CITY"

    private val prefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

//    override var city : Long
//        get() = prefs.getLong(PREF_CITY, -1)
//
//        set(value) {
//            prefs.edit().putLong(PREF_CITY, city).apply()
//        }

    override fun setCity(city: Long) = prefs.edit().putLong(PREF_CITY, city).apply()

    override fun getCity(): Long =
            prefs.getLong(PREF_CITY, -1)

}