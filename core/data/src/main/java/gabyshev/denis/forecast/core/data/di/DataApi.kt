package gabyshev.denis.forecast.core.data.di

import gabyshev.denis.forecast.core.data.api.CityApi
import gabyshev.denis.forecast.core.data.api.ResourceManagerApi
import gabyshev.denis.forecast.core.data.api.interactor.WeekInteractor

interface DataApi {

    fun cityApi(): CityApi

    fun resourceManagerApi(): ResourceManagerApi

    fun weekInteractor(): WeekInteractor
}