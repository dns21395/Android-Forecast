package org.densis.weather.data

import android.util.Log

actual class AppLogger {
    actual fun d(tag: String, message: String) {
        Log.d(tag, message)
    }
}