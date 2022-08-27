package gabyshev.denis.forecast.feature.select_city.store

import com.github.terrakok.modo.ModoReducer
import com.github.terrakok.modo.NavigationAction
import com.github.terrakok.modo.NavigationReducer
import com.github.terrakok.modo.NavigationState

class SelectCityNavigation(
    private val origin: NavigationReducer = ModoReducer(),
) : NavigationReducer {
    override fun invoke(
        action: NavigationAction,
        state: NavigationState,
    ): NavigationState {
        return origin.invoke(action, state)
    }
}