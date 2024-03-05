package gabyshev.denis.forecast.core.common

import androidx.compose.runtime.compositionLocalOf

val LocalCoreProvider = compositionLocalOf<CoreProvider> {
    error("CoreProvider not found")
}