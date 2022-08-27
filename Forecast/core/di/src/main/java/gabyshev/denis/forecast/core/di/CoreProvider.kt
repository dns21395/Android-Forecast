package gabyshev.denis.forecast.core.di

import android.content.Context
import gabyshev.denis.forecast.core.redux.Store
import gabyshev.denis.forecast.core.store.AppState

interface CoreProvider {

    fun provideContext(): Context

    fun appStore(): Store<AppState>
}