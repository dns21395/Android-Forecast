package gabyshev.denis.forecast.di

import android.content.Context
import com.github.terrakok.modo.Modo
import com.github.terrakok.modo.android.compose.AppReducer
import dagger.Module
import dagger.Provides
import gabyshev.denis.forecast.core.store.AppState
import gabyshev.denis.forecast.core.store.AppStore
import gabyshev.denis.forecast.core.store.reduce
import gabyshev.denis.forecast.store.middleware.NavigationMiddleware
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideModo(): Modo = Modo(AppReducer(context))

    @Provides
    @Singleton
    fun provideContext(): Context = context

    @Provides
    @Singleton
    fun provideStore(
        navigationMiddleware: NavigationMiddleware
    ): AppStore = AppStore(
        initialState = AppState(),
        reducer = AppState::reduce,
        middlewares = listOf(
            navigationMiddleware
        ),
        mainDispatcher = Dispatchers.Main
    )
}