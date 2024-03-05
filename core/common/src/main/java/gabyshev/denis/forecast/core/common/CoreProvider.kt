package gabyshev.denis.forecast.core.common

import gabyshev.denis.forecast.core.data.di.DataApi
import gabyshev.denis.forecast.core.navigation.RootNavigationQualifier

interface CoreProvider {


    fun provideDataApi(): DataApi

    @RootNavigationQualifier
    fun rootNavigation(): gabyshev.denis.forecast.core.navigation.Navigation
}