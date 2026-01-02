package org.densis.weather.data

expect class AppLogger {
    fun d(tag: String, message: String)
}