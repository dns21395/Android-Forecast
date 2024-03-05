package gabyshev.denis.forecast.core.common

import androidx.compose.runtime.compositionLocalOf

val LocalRootDependenciesProvider = compositionLocalOf<CoreProvider> {
    error("CoreProvider not found")
}