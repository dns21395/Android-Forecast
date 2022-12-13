import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import gabyshev.denis.forecast.core.common.getCoreProvider
import gabyshev.denis.forecast.feature.weather.WeatherViewModel
import gabyshev.denis.forecast.feature.weather.di.DaggerWeatherComponent

@Composable
fun WeatherScreen() {
    val coreProvider = LocalContext.current.getCoreProvider()
    val component = DaggerWeatherComponent.builder().coreProvider(coreProvider).build()
    val viewModel: WeatherViewModel by lazy { component.viewModel() }

    Column {

    }
}