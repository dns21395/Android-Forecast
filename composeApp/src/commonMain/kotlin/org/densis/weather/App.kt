package org.densis.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.densis.weather.select_city.SelectCity
import org.densis.weather.select_city.SelectCityViewModel
import org.densis.weather.select_city.presentation.SelectCityEffect
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import weather.composeapp.generated.resources.Res
import weather.composeapp.generated.resources.city_background

@Composable
@Preview
fun App() {
    val viewModel = koinViewModel<SelectCityViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.effects.collect { effect ->
            when (effect) {
                SelectCityEffect.ShowToast -> {

                }
            }
        }
    }

    val painter = painterResource(Res.drawable.city_background)

    Box(Modifier.fillMaxSize()) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        SelectCity(
            modifier = Modifier.fillMaxSize().statusBarsPadding().padding(horizontal = 16.dp),
            state = state,
            onEvent = { viewModel.onEvent(it) }
        )
    }
}