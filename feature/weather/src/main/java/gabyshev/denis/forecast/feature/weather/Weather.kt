import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.github.terrakok.modo.LocalContainerScreen
import com.github.terrakok.modo.stack.StackScreen
import com.github.terrakok.modo.stack.forward
import gabyshev.denis.forecast.feature.weather.R
import gabyshev.denis.forecast.feature.weather.Weather
import gabyshev.denis.forecast.feature.weather.Weather2

@Composable
fun WeatherScreen() {
//    val coreProvider = LocalContext.current.getCoreProvider()
//    val component = DaggerWeatherComponent.builder().coreProvider(coreProvider).build()
//    val viewModel: WeatherViewModel by lazy { component.viewModel() }

    val parent =  LocalContainerScreen.current as StackScreen

    Column(
        modifier = Modifier.clickable { parent.forward(Weather2()) }
    ) {
        Box(Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.background_1),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                contentDescription = null
            )
            Column(modifier = Modifier
                .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Hello, World", color = Color.White)
            }
        }
    }
}


@Composable
fun WeatherScreen2() {
    val parent =  LocalContainerScreen.current as StackScreen

    Column(
        modifier = Modifier.clickable { parent.forward(Weather()) }
    ) {
        Box(Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.background_2),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                contentDescription = null
            )
            Column(modifier = Modifier
                .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Hello, World 3", color = Color.White)
            }
        }
    }
}