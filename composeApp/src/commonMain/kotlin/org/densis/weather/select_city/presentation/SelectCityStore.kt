package org.densis.weather.select_city.presentation

import money.vivid.elmslie.core.store.ElmStore

typealias SelectCityStore = ElmStore<
        SelectCityEvent,
        SelectCityState,
        SelectCityEffect,
        SelectCityCommand>