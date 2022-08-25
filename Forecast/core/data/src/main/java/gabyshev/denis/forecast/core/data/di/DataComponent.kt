package gabyshev.denis.forecast.core.data.di

import dagger.Component
import gabyshev.denis.forecast.core.di.CoreProvider
import gabyshev.denis.forecast.core.di.PerFeature

@PerFeature
@Component(
    dependencies = [
        CoreProvider::class
    ],
    modules = [
        DataModule::class
    ]
)
interface DataComponent : DataApi {

    @Component.Factory
    interface Builder {
        fun create(
            coreProvider: CoreProvider,
        ): DataComponent
    }
}
