package gabyshev.denis.forecast.weather_week.ui

import androidx.lifecycle.ViewModel
import gabyshev.denis.forecast.weather_week.store.WeekState
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

internal class WeekViewModel @Inject constructor(
) : ViewModel() {

    val uiState = MutableStateFlow(WeekState())
}