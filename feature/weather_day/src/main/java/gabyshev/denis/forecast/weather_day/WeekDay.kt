package gabyshev.denis.forecast.weather_day

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.terrakok.modo.Screen
import com.github.terrakok.modo.ScreenKey
import com.github.terrakok.modo.generateScreenKey
import gabyshev.denis.forecast.feature.weather_day.R
import kotlinx.parcelize.Parcelize

@Parcelize
class WeekScreen(
    override val screenKey: ScreenKey = generateScreenKey(),
) : Screen {
    @Composable
    override fun Content() {
        WeekDay()
    }

}

@Composable
fun WeekDay() {
    Column {
        Box(Modifier.fillMaxSize()) {
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
