package gabyshev.denis.forecast.core.data.di

import gabyshev.denis.forecast.core.data.api.CityApi

interface DataApi {

    fun cityApi(): CityApi
}