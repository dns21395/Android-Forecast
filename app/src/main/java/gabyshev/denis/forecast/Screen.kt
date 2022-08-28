package gabyshev.denis.forecast

import androidx.compose.runtime.Composable
import com.github.terrakok.modo.android.compose.ComposeScreen
import com.github.terrakok.modo.android.compose.uniqueScreenKey
import gabyshev.denis.forecast.feature.select_city.ui.SelectCityScreen
import kotlinx.android.parcel.Parcelize

object Screen {

    @Parcelize
    class SelectCity(
        override val screenKey: String = uniqueScreenKey
    ): ComposeScreen("StatsScreen") {
        @Composable
        override fun Content() {
            SelectCityScreen()
        }
    }
}