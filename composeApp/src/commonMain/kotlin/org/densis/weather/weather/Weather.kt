package org.densis.weather.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.densis.weather.weather.domain.entity.WeatherForecastDay
import org.densis.weather.weather.domain.entity.WeatherImageType
import org.densis.weather.weather.presentation.WeatherEvent
import org.densis.weather.weather.presentation.WeatherState
import org.jetbrains.compose.resources.painterResource
import weather.composeapp.generated.resources.Res
import weather.composeapp.generated.resources.background_1
import weather.composeapp.generated.resources.background_2
import weather.composeapp.generated.resources.background_3
import weather.composeapp.generated.resources.d_clear_sky
import weather.composeapp.generated.resources.d_few_clouds
import weather.composeapp.generated.resources.d_rain
import weather.composeapp.generated.resources.mist
import weather.composeapp.generated.resources.n_clear_sky
import weather.composeapp.generated.resources.n_rain
import weather.composeapp.generated.resources.shower_rain
import weather.composeapp.generated.resources.snow
import weather.composeapp.generated.resources.thunderstorm

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
                .background(Color.Black.copy(alpha = 0.25f))
        )

        LazyColumn(
            modifier = modifier.padding(16.dp),
        ) {
            item {
                Spacer(Modifier.height(32.dp))
                Text(
                    text = state.cityName,
                    style = MaterialTheme.typography.headlineLarge.copy(
                        color = Color.White
                    ),
                )
            }
            item {
                Text(
                    text = state.temperature,
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontSize = 100.sp,
                        fontWeight = FontWeight.Thin,
                        color = Color.White
                    ),
                )
            }
            item {
                Text(
                    text = state.description,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        color = Color.White
                    ),
                )
            }

            item {
                Spacer(Modifier.height(32.dp))
            }

            itemsIndexed(state.forecast) { index, item ->
                val shape = when (index) {
                    0 -> RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp
                    )

                    state.forecast.lastIndex -> RoundedCornerShape(
                        bottomStart = 16.dp,
                        bottomEnd = 16.dp
                    )

                    else -> RectangleShape
                }

                val modifier = when (index) {
                    0 -> Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
                    state.forecast.lastIndex -> Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 8.dp,
                        bottom = 16.dp
                    )

                    else -> Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                }

                WeeklyForecastItem(item, shape, modifier)
            }

        }
    }
}

@Composable
fun WeeklyForecastItem(
    item: WeatherForecastDay,
    shape: Shape,
    modifier: Modifier
) {
    Card(
        shape = shape,
        colors = CardDefaults.cardColors(
            containerColor = Color.Black.copy(alpha = 0.5f)
        ),
    ) {
        Row(
            modifier = modifier
        ) {
            WeatherImage(item.imageType)
            Spacer(Modifier.width(16.dp))
            Text(
                text = item.dayName,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
            Spacer(Modifier.weight(1f))
            Text(
                text = item.temperature,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
        }
    }
}

@Composable
fun WeatherImage(imageType: WeatherImageType) {
    val painter = when (imageType) {
        WeatherImageType.CLEAR_SKY -> Res.drawable.d_clear_sky
        WeatherImageType.CLEAR_SKY_NIGHT -> Res.drawable.n_clear_sky
        WeatherImageType.FEW_CLOUDS -> Res.drawable.d_few_clouds
        WeatherImageType.FEW_CLOUDS_NIGHT -> Res.drawable.d_few_clouds
        WeatherImageType.RAIN -> Res.drawable.d_rain
        WeatherImageType.RAIN_NIGHT -> Res.drawable.n_rain
        WeatherImageType.MIST -> Res.drawable.mist
        WeatherImageType.SHOWER_RAIN -> Res.drawable.shower_rain
        WeatherImageType.SNOW -> Res.drawable.snow
        WeatherImageType.THUNDERSTORM -> Res.drawable.thunderstorm
    }

    Image(
        painter = painterResource(painter),
        contentDescription = null,
        modifier = Modifier.size(36.dp)
    )
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