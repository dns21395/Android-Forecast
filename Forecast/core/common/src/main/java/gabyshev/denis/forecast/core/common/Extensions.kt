package gabyshev.denis.forecast.core.common

import android.content.Context

fun Context.getCoreProvider() = (this.applicationContext as ApplicationApi).coreProvider()