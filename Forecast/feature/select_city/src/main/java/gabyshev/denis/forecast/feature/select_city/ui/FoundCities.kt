package gabyshev.denis.forecast.feature.select_city.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import gabyshev.denis.forecast.core.data.api.entity.City

@Composable
fun FoundCities(
    cities: List<City>,
    onCitySelected: (Int) -> Unit,
) {
    LazyColumn {
        items(cities) { city ->
            Text("${city.name}, ${city.country}")
        }
    }
}