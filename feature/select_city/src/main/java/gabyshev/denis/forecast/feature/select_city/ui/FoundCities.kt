package gabyshev.denis.forecast.feature.select_city.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
    onCitySelected: (City) -> Unit,
) {
    LazyColumn(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        items(cities) { city ->
            CityCard(
                city = city,
                onCitySelected = { onCitySelected.invoke(it) },
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Composable
fun CityCard(
    city: City,
    onCitySelected: (City) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .clickable { onCitySelected(city) }
            .background(Color.White.copy(alpha = 0.25f))
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            text = city.name,
            color = Color.White
        )
    }
}