package gabyshev.denis.forecast.core.data.di

import gabyshev.denis.forecast.core.data.api.CityApi
import gabyshev.denis.forecast.core.data.api.ResourceManagerApi

interface DataApi {

    fun cityApi(): CityApi

    fun resourceManagerApi(): ResourceManagerApi
}