package gabyshev.denis.forecast.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import gabyshev.denis.forecast.core.ui.theme.ForecastTheme
import gabyshev.denis.forecast.di.AppApi

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (applicationContext as AppApi).getComponent().inject(this)
        (applicationContext as AppApi).getComponent().mainViewModel()



        setContent {
            val navController = rememberNavController()

            ForecastTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavGraph(modifier = Modifier, navController = navController)
                }
            }
        }
    }
}
