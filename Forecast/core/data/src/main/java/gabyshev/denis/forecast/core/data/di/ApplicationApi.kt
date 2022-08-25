package gabyshev.denis.forecast.core.data.di

import gabyshev.denis.forecast.core.di.CoreProvider

interface ApplicationApi {

    fun coreProvider(): CoreProvider
}