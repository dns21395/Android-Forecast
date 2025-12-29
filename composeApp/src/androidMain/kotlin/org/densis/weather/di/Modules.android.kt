package org.densis.weather.di

import org.densis.weather.data.AppLogger
import org.densis.weather.data.DataStoreFactory
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {
        single { DataStoreFactory(androidApplication()).create() }
        single { AppLogger() }
    }