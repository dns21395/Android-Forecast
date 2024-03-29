package gabyshev.denis.forecast.weather_week.ui

import androidx.lifecycle.ViewModel
import gabyshev.denis.forecast.weather_week.store.InitWeekScreen
import gabyshev.denis.forecast.weather_week.store.WeekStore
import javax.inject.Inject

internal class WeekViewModel @Inject constructor(
    private val store: WeekStore
) : ViewModel() {

    val uiState = store.state

    init {
        store.wire()
        store.dispatch(InitWeekScreen)
    }
}