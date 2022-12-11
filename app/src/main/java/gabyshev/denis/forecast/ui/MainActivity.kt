package gabyshev.denis.forecast.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.github.terrakok.modo.Modo
import com.github.terrakok.modo.stack.StackScreen
import gabyshev.denis.forecast.RootStack
import gabyshev.denis.forecast.SelectCity
import gabyshev.denis.forecast.core.ui.theme.ForecastTheme
import gabyshev.denis.forecast.di.AppApi

class MainActivity : ComponentActivity() {

    private var rootScreen: StackScreen? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (applicationContext as AppApi).getComponent().inject(this)
        (applicationContext as AppApi).getComponent().mainViewModel()


        rootScreen = Modo.init(savedInstanceState, rootScreen) {
            RootStack(SelectCity())
        }

        setContent {
            ForecastTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    rootScreen?.Content()
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Modo.save(outState, rootScreen)
        super.onSaveInstanceState(outState)
    }
}
