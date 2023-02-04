package gabyshev.denis.forecast.core.common

import android.content.Context
import gabyshev.denis.forecast.core.data.di.DataApi
import gabyshev.denis.forecast.core.redux.Store
import gabyshev.denis.forecast.core.store.AppState

interface CoreProvider {

    fun provideContext(): Context

    fun appStore(): Store<AppState>

    fun provideDataApi(): DataApi
}