package gabyshev.denis.forecast.weather_week.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import gabyshev.denis.forecast.weather_week.store.WeekStore
import javax.inject.Inject

internal class WeekViewModel @Inject constructor(
    private val store: WeekStore
) : ViewModel() {

    init {
        store.wire()
    }

    fun onButtonClicked() {
        Log.d("GTA5", "Hello, World")
    }
}