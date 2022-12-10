package gabyshev.denis.forecast.core.data.api

import gabyshev.denis.forecast.core.data.data.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl")
    suspend fun getWeatherData(
        @Query("latitude") lat: Double = 55.691048,
        @Query("longitude") long: Double = 37.727890
    ): WeatherDto
}