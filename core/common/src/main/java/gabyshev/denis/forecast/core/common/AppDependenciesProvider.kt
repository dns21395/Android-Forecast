package gabyshev.denis.forecast.core.common

import androidx.compose.runtime.compositionLocalOf

interface AppDependenciesProvider {

    fun coreProvider(): CoreProvider

    val destinations: Destinations
}

val LocalAppDependenciesProvider = compositionLocalOf<AppDependenciesProvider> {
    error("AppDependenciesProvider not found")
}
