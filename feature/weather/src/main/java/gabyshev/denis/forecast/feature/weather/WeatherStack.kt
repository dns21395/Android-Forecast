package gabyshev.denis.forecast.feature.weather

import WeatherScreen
import WeatherScreen2
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.terrakok.modo.Screen
import com.github.terrakok.modo.ScreenKey
import com.github.terrakok.modo.generateScreenKey
import com.github.terrakok.modo.multiscreen.MultiScreen
import com.github.terrakok.modo.multiscreen.MultiScreenNavModel
import com.github.terrakok.modo.multiscreen.selectContainer
import com.github.terrakok.modo.stack.StackNavModel
import com.github.terrakok.modo.stack.StackScreen
import kotlinx.parcelize.Parcelize

@Parcelize
class WeatherStack(
    private val stackNavModel: MultiScreenNavModel = MultiScreenNavModel(
        containers = listOf(
            SampleStack(Weather()),
            SampleStack(Weather2())
        ),
        selected = 0
    ),
) : MultiScreen(stackNavModel) {

    @Composable
    override fun Content() {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.padding(top = 16.dp).weight(1f)) {
                Row {
                    for ((pos, container) in navigationState.containers.withIndex()) {
                        if (pos == navigationState.selected) {
                            Box(modifier = Modifier.weight(1f)) {
                                // внутри вызывается используется SaveableStateProvider с одинаковым ключом для экрана
                                Content(container)
                            }
                        }
                    }
                }
            }
            Row {
                Button(onClick = { selectContainer(0)}) {
                    Text("Day")
                }
                Button(onClick = { selectContainer(1) }) {
                    Text("Weather")
                }
            }
        }
    }

}

@Parcelize
class SampleStack(
    private val stackNavModel: StackNavModel,
) : StackScreen(stackNavModel) {

    constructor(rootScreen: Screen) : this(StackNavModel(rootScreen))

    @Composable
    override fun Content() {
        TopScreenContent()
    }
}


@Parcelize
class Weather(
    override val screenKey: ScreenKey = generateScreenKey(),
) : Screen {

    @Composable
    override fun Content() {
        WeatherScreen()
    }
}

@Parcelize
class Weather2(
    override val screenKey: ScreenKey = generateScreenKey(),
) : Screen {

    @Composable
    override fun Content() {
        WeatherScreen2()
    }
}