package gabyshev.denis.forecast.di

import android.content.Context
import com.github.terrakok.modo.Modo
import com.github.terrakok.modo.android.compose.AppReducer
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideModo(): Modo = Modo(AppReducer(context))
}