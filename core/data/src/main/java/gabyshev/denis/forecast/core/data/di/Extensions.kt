package gabyshev.denis.forecast.core.data.di

import android.content.Context

fun buildDataComponent(context: Context): DataComponent =
    DaggerDataComponent
        .builder()
        .dataModule(DataModule(context))
        .build()