package gabyshev.denis.forecast.di

import dagger.Component
import gabyshev.denis.forecast.core.di.CoreProvider
import javax.inject.Singleton

@Component(
    modules = [AppModule::class]
)
@Singleton
interface AppComponent : CoreProvider
