package gabyshev.denis.forecast.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.github.terrakok.modo.stack.StackNavModel
import com.github.terrakok.modo.stack.StackScreen
import gabyshev.denis.forecast.core.common.CoreProvider
import gabyshev.denis.forecast.core.common.LocalCoreProvider
import gabyshev.denis.forecast.core.di.ComponentHolder
import gabyshev.denis.forecast.core.di.daggerViewModel
import gabyshev.denis.forecast.core.navigation.navigate
import gabyshev.denis.forecast.di.AppModule
import gabyshev.denis.forecast.di.DaggerAppComponent
import kotlinx.coroutines.flow.collectLatest
import kotlinx.parcelize.Parcelize

private const val KEY_COMPONENT = "KEY_APP_COMPONENT"
private const val KEY_VIEWMODEL = "KEY_APP_VIEWMODEL"

@Parcelize
class MainStackScreen(
    private val navigationModel: StackNavModel,
) : StackScreen(navigationModel = navigationModel) {

    constructor() : this(StackNavModel(emptyList()))

    @Composable
    override fun Content() {

        val context = LocalContext.current
        val componentHolder = daggerViewModel(key = KEY_COMPONENT) {
            ComponentHolder(DaggerAppComponent
                .builder()
                .appModule(AppModule(context))
                .build())
        }
        val viewModel =
            daggerViewModel(key = KEY_VIEWMODEL) { componentHolder.component.viewModel() }

        LaunchedEffect(Unit) {
            viewModel.navigationCommands.collectLatest { command ->
                navigate(command)
            }
        }

        CompositionLocalProvider(
            LocalCoreProvider provides componentHolder.component as CoreProvider
        ) {
            TopScreenContent()
        }
    }
}