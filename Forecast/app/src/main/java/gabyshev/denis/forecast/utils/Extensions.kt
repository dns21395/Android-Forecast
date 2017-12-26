package gabyshev.denis.forecast.utils

import android.app.Activity
import gabyshev.denis.forecast.App

/**
 * Created by denis on 24/12/2017.
 */
val Activity.app: App
    get() = application as App