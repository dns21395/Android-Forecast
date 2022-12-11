package gabyshev.denis.forecast.core.data.domain.interactor

import android.content.Context
import com.google.gson.Gson
import gabyshev.denis.forecast.core.data.api.entity.City
import javax.inject.Inject

class UserCity @Inject constructor(
    private val context: Context,
) {

    companion object {
        private const val PREF_NAME = "PREF_NAME"
        private const val PREF_CITY = "PREF_CITY"
    }

    private val preferences by lazy { context.getSharedPreferences(PREF_NAME, 0) }
    private val gson by lazy { Gson() }

    fun updateCity(city: City) {
        val json = gson.toJson(city)
        preferences.edit().putString(PREF_CITY, json).apply()
    }

    fun getCity(): City {
        val json = preferences.getString(PREF_CITY, "")
        return gson.fromJson(json, City::class.java)
    }
}