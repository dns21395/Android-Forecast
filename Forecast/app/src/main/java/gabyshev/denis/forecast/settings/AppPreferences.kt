package gabyshev.denis.forecast.settings

import android.content.Context
import android.preference.PreferenceManager

/**
 * Created by Borya on 22.07.2017.
 */
class AppPreferences {
    private val CITY = "city"

    companion object {
        private var instance: AppPreferences? = null

        fun instance(): AppPreferences? {
            if(instance == null) {
                instance = AppPreferences()
            }
            return instance
        }
    }

    fun setCity(context: Context, city: Int) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putInt(CITY, city)
                .apply()
    }

    fun getCity(context: Context): Int = PreferenceManager.getDefaultSharedPreferences(context).getInt(CITY, 0)
}