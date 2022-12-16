package gabyshev.denis.forecast.weather_week.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import gabyshev.denis.forecast.core.common.getCoreProvider
import gabyshev.denis.forecast.core.di.daggerViewModel
import gabyshev.denis.forecast.feature.weather_week.R
import gabyshev.denis.forecast.weather_week.di.DaggerWeekComponent

@Composable
fun WeekScreen() {
    Column(
        modifier = Modifier.clickable {  }
    ) {
        val coreProvider = LocalContext.current.getCoreProvider()
        val component = DaggerWeekComponent.builder().coreProvider(coreProvider).build()
        val viewModel: WeekViewModel = daggerViewModel { component.viewModel() }

        Box(Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.background_2),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                contentDescription = null
            )
            Column(modifier = Modifier
                .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = { viewModel.onButtonClicked() }) {
                    Text(text = "Hello, World 3", color = Color.White)
                }
            }
        }
    }
}