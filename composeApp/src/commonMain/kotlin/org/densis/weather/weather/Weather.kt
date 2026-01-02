package org.densis.weather.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.densis.weather.weather.presentation.WeatherEvent
import org.densis.weather.weather.presentation.WeatherState
import org.jetbrains.compose.resources.painterResource
import weather.composeapp.generated.resources.Res
import weather.composeapp.generated.resources.background_1
import weather.composeapp.generated.resources.background_2
import weather.composeapp.generated.resources.background_3

@Composable
fun Weather(
    modifier: Modifier = Modifier,
    state: WeatherState,
    onEvent: (WeatherEvent) -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundImage(Modifier.matchParentSize())

        Box(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Black.copy(alpha = 0.1f))
        )

        LazyColumn(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(Modifier.height(32.dp))
                Text(
                    text = state.cityName,
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White
                )
            }
            item {
                Text(
                    text = state.temperature ,
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun BackgroundImage(modifier: Modifier) {
    val images = listOf(
        Res.drawable.background_1,
        Res.drawable.background_2,
        Res.drawable.background_3
    )
    val painter = painterResource(images.random())

    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}