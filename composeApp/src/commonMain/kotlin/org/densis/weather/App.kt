package org.densis.weather

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.densis.weather.select_city.SelectCity
import org.densis.weather.select_city.SelectCityViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    val viewModel = koinViewModel<SelectCityViewModel>()
    SelectCity(modifier = Modifier.fillMaxSize().statusBarsPadding().padding(horizontal = 16.dp))
}