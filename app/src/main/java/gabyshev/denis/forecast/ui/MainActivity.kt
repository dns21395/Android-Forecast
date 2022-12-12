package gabyshev.denis.forecast.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.github.terrakok.modo.Modo
import gabyshev.denis.forecast.RootStack
import gabyshev.denis.forecast.SelectCity
import gabyshev.denis.forecast.core.ui.theme.ForecastTheme
import gabyshev.denis.forecast.di.AppApi

class MainActivity : ComponentActivity() {

    private val appNavigation: AppNavigation by lazy {
        (applicationContext as AppApi).getComponent().navigation()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (applicationContext as AppApi).getComponent().inject(this)
        (applicationContext as AppApi).getComponent().mainViewModel()


        appNavigation.setup(
            Modo.init(savedInstanceState, appNavigation.getStack()) { RootStack(SelectCity()) }
        )

        setContent {
            ForecastTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    appNavigation.Content()
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Modo.save(outState, appNavigation.getStack())
        super.onSaveInstanceState(outState)
    }
}
