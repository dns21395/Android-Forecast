package gabyshev.denis.forecast.feature.select_city.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import gabyshev.denis.forecast.core.data.api.entity.City

@Composable
fun FoundCities(
    cities: List<City>,
    onCitySelected: (Long) -> Unit,
) {
    LazyColumn(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        items(cities) { city ->
            CityCard(
                cityName = "${city.name}, ${city.country}",
                onCitySelected = { onCitySelected.invoke(city.id) },
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Composable
fun CityCard(
    cityName: String,
    onCitySelected: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .background(Color.White.copy(alpha = 0.25f))
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            text = cityName,
            color = Color.White
        )
    }
}