package org.densis.weather

import androidx.compose.ui.window.ComposeUIViewController
import org.densis.weather.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }