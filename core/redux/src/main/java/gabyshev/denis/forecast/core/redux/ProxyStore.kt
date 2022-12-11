package gabyshev.denis.forecast.core.redux

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class ProxyStore<State : Any, ParentState : Any>(
    middlewares: List<Middleware<State>> = emptyList(),
    private val initialState: State,
    private val reducer: ((State, Action) -> (State)),
    private val parentStore: Store<ParentState>,
    private val mainDispatcher: CoroutineDispatcher
) : Store<State>(
    initialState = initialState,
    reducer = reducer,
    middlewares = middlewares,
    mainDispatcher = mainDispatcher
) {

    override val actions: Flow<Action> = parentStore.actions

    override fun dispatch(action: Action) {
        parentStore.dispatch(action)
    }
}