package gabyshev.denis.forecast.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.github.terrakok.modo.Modo
import com.github.terrakok.modo.android.compose.ComposeRenderImpl
import com.github.terrakok.modo.android.compose.init
import com.github.terrakok.modo.android.compose.saveState
import com.github.terrakok.modo.back
import gabyshev.denis.forecast.Screen
import gabyshev.denis.forecast.core.ui.theme.ForecastTheme
import gabyshev.denis.forecast.di.AppApi
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var modo: Modo

    private val render = ComposeRenderImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (applicationContext as AppApi).getComponent().inject(this)
        (applicationContext as AppApi).getComponent().mainViewModel()

        modo.init(savedInstanceState) { Screen.SelectCity() }
        setContent {
            ForecastTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        render.Content()
                    }
                }
            }
        }
    }
    override fun onResume() {
        super.onResume()
        modo.render = render
    }

    override fun onPause() {
        super.onPause()
        modo.render = null
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        modo.saveState(outState)
    }

    override fun onBackPressed() {
        modo.back()
    }
}
