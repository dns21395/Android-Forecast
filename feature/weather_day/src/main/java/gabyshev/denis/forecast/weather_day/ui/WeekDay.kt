package gabyshev.denis.forecast.weather_day.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.terrakok.modo.Screen
import com.github.terrakok.modo.ScreenKey
import com.github.terrakok.modo.generateScreenKey
import gabyshev.denis.forecast.core.common.LocalCoreProvider
import gabyshev.denis.forecast.core.di.ComponentHolder
import gabyshev.denis.forecast.core.di.daggerViewModel
import gabyshev.denis.forecast.feature.weather_day.R
import gabyshev.denis.forecast.weather_day.di.DaggerDayComponent
import kotlinx.parcelize.Parcelize

private const val KEY_COMPONENT = "KEY_WEATHER_DAY_COMPONENT"
private const val KEY_VIEWMODEL = "KEY_WEATHER_DAY_VIEWMODEL"

@Parcelize
class WeekScreen(
    override val screenKey: ScreenKey = generateScreenKey(),
) : Screen {
    @Composable
    override fun Content() {
        val coreProvider = LocalCoreProvider.current
        val componentHolder = daggerViewModel(key = "$screenKey$KEY_COMPONENT") {
            ComponentHolder(DaggerDayComponent.factory().create(coreProvider))
        }

        val viewModel: DayViewModel = daggerViewModel(key = "$screenKey$KEY_VIEWMODEL") {
            componentHolder.component.viewModel()
        }

        WeekDay(
            { viewModel.onWeekButtonClicked() }
        )
    }

}

@Composable
fun WeekDay(
    onWeekButtonClicked: () -> Unit
) {
    Column {
        Box(Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 32.dp,
                        end = 16.dp
                    ), horizontalArrangement = Arrangement.End
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_week),
                    contentDescription = null,
                    modifier = Modifier.clickable { onWeekButtonClicked() }
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Paris",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Monday 03:35 PM",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )
                Spacer(Modifier.height(32.dp))
                Image(
                    painter = painterResource(id = R.drawable.n_clear_sky),
                    contentDescription = null
                )
                Spacer(Modifier.height(32.dp))
                Text(
                    text = "14 °C",
                    color = Color.White,
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "OVERCAST CLOUDS",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Light
                )
            }
        }
    }
}
