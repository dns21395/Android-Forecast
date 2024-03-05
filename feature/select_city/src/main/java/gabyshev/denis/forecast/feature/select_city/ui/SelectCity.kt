package gabyshev.denis.forecast.feature.select_city.ui

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.github.terrakok.modo.stack.StackNavModel
import com.github.terrakok.modo.stack.StackScreen
import gabyshev.denis.forecast.core.common.LocalCoreProvider
import gabyshev.denis.forecast.core.common.getCoreProvider
import gabyshev.denis.forecast.core.di.ComponentHolder
import gabyshev.denis.forecast.core.di.daggerViewModel
import gabyshev.denis.forecast.core.navigation.navigate
import gabyshev.denis.forecast.feature.select_city.R
import gabyshev.denis.forecast.feature.select_city.di.DaggerSelectCityComponent
import gabyshev.denis.forecast.feature.select_city.domain.entity.ScreenType
import gabyshev.denis.forecast.feature.select_city.store.SelectCityState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.parcelize.Parcelize

private const val KEY_COMPONENT = "KEY_SELECT_CITY_COMPONENT"
private const val KEY_VIEWMODEL = "KEY_SELECT_CITY_VIEWMODEL"

@Parcelize
class SelectCityStack(
    private val stackNavModel: StackNavModel,
) : StackScreen(stackNavModel) {
    constructor() : this(StackNavModel(emptyList()))

    @Composable
    override fun Content() {
        val coreProvider = LocalCoreProvider.current
        val componentHolder = daggerViewModel(key = "${stackNavModel.screenKey}$KEY_COMPONENT") {
            ComponentHolder(DaggerSelectCityComponent.factory().create(coreProvider))
        }
        val viewModel: SelectCityViewModel =
            daggerViewModel(key = "${stackNavModel.screenKey}$KEY_VIEWMODEL") {
                componentHolder.component.selectCityViewModel()
            }


        ShowToastEvent(viewModel = viewModel)

        LaunchedEffect(Unit) {
            viewModel.navigationCommands.collectLatest {
                navigate(it)
            }
        }

        val state = viewModel.state.collectAsState(initial = SelectCityState())

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
                FoundCities(state.value.cities) { viewModel.onCitySelected(it) }
            }
        }
    }
}

@Composable
fun ShowToastEvent(viewModel: SelectCityViewModel) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel
            .toastMessage
            .collect { message ->
                Toast.makeText(
                    context,
                    message,
                    Toast.LENGTH_SHORT,
                ).show()
            }
    }
}