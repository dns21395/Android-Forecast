package org.densis.weather.weather

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.densis.weather.weather.presentation.WeatherEvent
import org.densis.weather.weather.presentation.WeatherState

@Composable
fun Weather(
    modifier: Modifier = Modifier,
    state: WeatherState,
    onEvent: (WeatherEvent) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(state.cityName)
    }
}