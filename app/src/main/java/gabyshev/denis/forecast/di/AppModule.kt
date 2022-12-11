package gabyshev.denis.forecast.di

import android.content.Context
import dagger.Module
import dagger.Provides
import gabyshev.denis.forecast.core.data.di.DataApi
import gabyshev.denis.forecast.core.data.di.buildDataComponent
import gabyshev.denis.forecast.core.store.AppState
import gabyshev.denis.forecast.core.store.AppStore
import gabyshev.denis.forecast.core.store.reduce
import gabyshev.denis.forecast.store.middleware.NavigationMiddleware
import gabyshev.denis.forecast.store.middleware.ToastMiddleware
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideContext(): Context = context

    @Provides
    @Singleton
    fun provideStore(
        navigationMiddleware: NavigationMiddleware,
        toastMiddleware: ToastMiddleware,
    ): AppStore = AppStore(
        initialState = AppState(),
        reducer = AppState::reduce,
        middlewares = listOf(
            navigationMiddleware,
            toastMiddleware,
        ),
        mainDispatcher = Dispatchers.Main
    )

    @Provides
    @Singleton
    fun provideDataApi(): DataApi = buildDataComponent(context)
}