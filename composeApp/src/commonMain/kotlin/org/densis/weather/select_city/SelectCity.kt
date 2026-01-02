package org.densis.weather.select_city

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.densis.weather.select_city.presentation.SelectCityEvent
import org.densis.weather.select_city.presentation.SelectCityState
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import weather.composeapp.generated.resources.Res
import weather.composeapp.generated.resources.magnify
import weather.composeapp.generated.resources.select_city_hint

@Composable
fun SelectCity(
    modifier: Modifier = Modifier,
    state: SelectCityState,
    onEvent: (SelectCityEvent) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = state.cityName,
            onValueChange = { onEvent(SelectCityEvent.OnInputText(it)) },
            placeholder = {
                Text(
                    text = stringResource(Res.string.select_city_hint),
                    style = MaterialTheme.typography.titleLarge
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(Res.drawable.magnify),
                    contentDescription = null
                )
            },
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onEvent(SelectCityEvent.OnSelectButtonClicked) },
            modifier = Modifier.align(Alignment.End).padding(8.dp)
        ) {
            Text("search", style = MaterialTheme.typography.titleLarge)
        }
    }
}