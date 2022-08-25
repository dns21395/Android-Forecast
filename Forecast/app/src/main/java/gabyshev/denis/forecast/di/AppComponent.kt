package gabyshev.denis.forecast.di

import dagger.Component
import gabyshev.denis.forecast.MainActivity
import javax.inject.Singleton

@Component(
    modules = [AppModule::class]
)
@Singleton
interface AppComponent
