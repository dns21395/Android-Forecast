package org.densis.weather

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object AppGraph : Route

    @Serializable
    data object SelectCity : Route

    @Serializable
    data object Weather : Route
}