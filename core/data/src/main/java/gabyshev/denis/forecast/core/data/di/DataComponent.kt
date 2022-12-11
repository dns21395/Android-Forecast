package gabyshev.denis.forecast.core.data.di

import dagger.Component
import gabyshev.denis.forecast.core.di.PerFeature

@PerFeature
@Component(
    modules = [
        DataModule::class
    ]
)
interface DataComponent : DataApi
