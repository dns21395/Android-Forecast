package gabyshev.denis.forecast.weather_day.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

internal class DayViewModel @Inject constructor(
) : ViewModel() {

    fun onWeekButtonClicked() {
        Log.d("GTA5", "week button")
    }
}