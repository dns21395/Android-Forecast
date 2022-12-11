package gabyshev.denis.forecast.feature.select_city.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import gabyshev.denis.forecast.core.common.getCoreProvider
import gabyshev.denis.forecast.core.di.daggerViewModel
import gabyshev.denis.forecast.feature.select_city.R
import gabyshev.denis.forecast.feature.select_city.di.DaggerSelectCityComponent
import gabyshev.denis.forecast.feature.select_city.domain.entity.ScreenType
import gabyshev.denis.forecast.feature.select_city.store.SelectCityState

@Composable
fun SelectCityScreen() {
    val coreProvider = LocalContext.current.getCoreProvider()
    val component = DaggerSelectCityComponent.builder().coreProvider(coreProvider).build()
    val viewModel: SelectCityViewModel = daggerViewModel { component.selectCityViewModel() }

    val state = viewModel.uiState.collectAsState(initial = SelectCityState())

    Box(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.city_background),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            contentDescription = null
        )

        AnimatedVisibility(
            visible = state.value.currentScreen == ScreenType.SEARCH_CITY,
            exit = slideOutHorizontally(
                targetOffsetX = { fullWidth -> -fullWidth }
            )
        ) {
            SearchCity(viewModel = viewModel)
        }

        AnimatedVisibility(
            visible = state.value.currentScreen == ScreenType.FOUND_CITIES,
            enter = slideInHorizontally(
                initialOffsetX = { fullWidth -> fullWidth * 2 }
            ),
            exit = slideOutHorizontally(
                targetOffsetX = { fullWidth -> fullWidth * 2 }
            )
        ) {
            FoundCities(state.value.cities, {})
        }
    }
}