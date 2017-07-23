package gabyshev.denis.forecast.injection

import dagger.Module
import dagger.Provides
import gabyshev.denis.forecast.utils.RxBus
import gabyshev.denis.forecast.App
import javax.inject.Singleton

/**
 * Created by Borya on 22.07.2017.
 */
@Module class AppModule(val app: App) {
    @Provides @Singleton fun provideApp() = app
    @Provides @Singleton fun provideBus() = RxBus()
}