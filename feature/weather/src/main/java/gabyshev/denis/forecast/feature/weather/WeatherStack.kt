package gabyshev.denis.forecast.feature.weather

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import com.github.terrakok.modo.stack.StackNavModel
import com.github.terrakok.modo.stack.StackScreen
import gabyshev.denis.forecast.core.common.LocalCoreProvider
import gabyshev.denis.forecast.core.di.ComponentHolder
import gabyshev.denis.forecast.core.di.daggerViewModel
import gabyshev.denis.forecast.core.navigation.navigate
import gabyshev.denis.forecast.feature.weather.di.DaggerWeatherComponent
import kotlinx.coroutines.flow.collectLatest
import kotlinx.parcelize.Parcelize

private const val KEY_COMPONENT = "KEY_WEATHER_COMPONENT"
private const val KEY_VIEWMODEL = "KEY_WEATHER_VIEWMODEL"

@Parcelize
class WeatherStack(
    private val stackNavModel: StackNavModel,
) : StackScreen(stackNavModel) {

    constructor() : this(StackNavModel(emptyList()))

    @Composable
    override fun Content() {
        val coreProvider = LocalCoreProvider.current
        val componentHolder = daggerViewModel(key = "${stackNavModel.screenKey}$KEY_COMPONENT") {
            ComponentHolder(DaggerWeatherComponent.factory().create(coreProvider))
        }
        val viewModel: WeatherViewModel =
            daggerViewModel(key = "${stackNavModel.screenKey}$KEY_VIEWMODEL") {
                componentHolder.component.viewModel()
            }

        LaunchedEffect(Unit) {
            viewModel.navigationCommands.collectLatest {
                navigate(it)
            }
        }

        TopScreenContent()
    }
}
