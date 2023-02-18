package gabyshev.denis.forecast.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import gabyshev.denis.forecast.Navigation
import gabyshev.denis.forecast.core.common.AppDependenciesProvider
import gabyshev.denis.forecast.core.common.LocalAppDependenciesProvider
import gabyshev.denis.forecast.core.ui.theme.ForecastTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ForecastTheme {
                CompositionLocalProvider(
                    LocalAppDependenciesProvider provides (applicationContext as AppDependenciesProvider)
                ) {
                    Navigation()
                }
            }
        }
    }
}
