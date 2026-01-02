package org.densis.weather.select_city.presentation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import money.vivid.elmslie.core.store.Actor
import org.densis.weather.select_city.domain.SetCurrentCityUseCase

class SelectCityActor(
    private val setCurrentCityUseCase: SetCurrentCityUseCase
) : Actor<SelectCityCommand, SelectCityEvent>() {

    override fun execute(command: SelectCityCommand): Flow<SelectCityEvent> {
        return when (command) {
            is SelectCityCommand.SetCurrentCity -> flow {
                setCurrentCityUseCase.execute(command.cityName)
                emit(SelectCityEvent.OnSelectFinished)
            }
        }
    }
}