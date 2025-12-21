package org.densis.weather.select_city

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.densis.weather.select_city.presentation.SelectCityEvent
import org.densis.weather.select_city.presentation.SelectCityState

@Composable
fun SelectCity(
    modifier: Modifier = Modifier,
    state: SelectCityState,
    onEvent: (SelectCityEvent) -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        TextField(
            value = state.text,
            onValueChange = { onEvent(SelectCityEvent.OnInputText(it)) }
        )
        Button(
            onClick = { onEvent(SelectCityEvent.OnShowToast) }
        ) {
            Text("click")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = state.yourText
        )
    }
}