package gabyshev.denis.forecast.weather_week.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import gabyshev.denis.forecast.core.common.getCoreProvider
import gabyshev.denis.forecast.core.di.daggerViewModel
import gabyshev.denis.forecast.feature.weather_week.R
import gabyshev.denis.forecast.weather_week.di.DaggerWeekComponent
import gabyshev.denis.forecast.weather_week.store.WeekState

@Composable
fun WeekScreen() {
    Column(
        modifier = Modifier.clickable { }
    ) {
        val coreProvider = LocalContext.current.getCoreProvider()
        val component = DaggerWeekComponent.builder().coreProvider(coreProvider).build()
        val viewModel: WeekViewModel = daggerViewModel { component.viewModel() }

        val state = viewModel.uiState.collectAsState(initial = WeekState())


        Box(Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.background_2),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                contentDescription = null
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                items(state.value.days) { day ->
                    Text(
                        text = "${day.dayName} ${day.minTemperature} ${day.maxTemperature}",
                        modifier = Modifier.padding(16.dp),
                        color = Color.White
                    )
                }
            }
        }
    }
}