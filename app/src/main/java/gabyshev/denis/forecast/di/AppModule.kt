package gabyshev.denis.forecast.di

import android.content.Context
import dagger.Module
import dagger.Provides
import gabyshev.denis.forecast.core.data.di.DataApi
import gabyshev.denis.forecast.core.data.di.buildDataComponent
import gabyshev.denis.forecast.core.navigation.Navigation
import gabyshev.denis.forecast.core.navigation.RootNavigationQualifier
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideDataApi(): DataApi = buildDataComponent(context)

    @Provides
    @Singleton
    @RootNavigationQualifier
    fun provideRootNavigation(): Navigation = Navigation()
}