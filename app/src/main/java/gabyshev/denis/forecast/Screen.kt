package gabyshev.denis.forecast

import androidx.compose.runtime.Composable
import com.github.terrakok.modo.Screen
import com.github.terrakok.modo.ScreenKey
import com.github.terrakok.modo.generateScreenKey
import com.github.terrakok.modo.stack.StackNavModel
import com.github.terrakok.modo.stack.StackScreen
import com.github.terrakok.modo.stack.StackState
import gabyshev.denis.forecast.feature.select_city.ui.SelectCityScreen
import kotlinx.parcelize.Parcelize

@Parcelize
class RootStack(
    private val stackNavModel: StackNavModel,
) : StackScreen(stackNavModel) {

    constructor(rootScreen: Screen) : this(StackNavModel(StackState(rootScreen)))
}

@Parcelize
class SelectCity(
    override val screenKey: ScreenKey = generateScreenKey()
): Screen {

    @Composable
    override fun Content() {
        SelectCityScreen()
    }
}
