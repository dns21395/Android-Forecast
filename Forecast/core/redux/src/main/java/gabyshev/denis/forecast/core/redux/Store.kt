package gabyshev.denis.forecast.core.redux

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

open class Store<State : Any>(
    initialState: State,
    private val reducer: ((State, Action) -> (State)),
    private val middlewares: List<Middleware<State>> = emptyList(),
    private val mainDispatcher: CoroutineDispatcher
) {
    private val mutableState = MutableStateFlow(initialState)
    private val mutableActions = MutableSharedFlow<Action>()

    val state: Flow<State> = mutableState
    open val actions: Flow<Action> = mutableActions

    private val currentState = mutableState.value

    open fun wire() {
        GlobalScope.launch(mainDispatcher) {
            actions.collect { action ->
                middlewares.forEach { it -> it.bind(action, currentState) { dispatch(it) } }
                mutableState.emit(reducer.invoke(currentState, action))
            }
        }
    }

    open fun dispatch(action: Action) {
        GlobalScope.launch(mainDispatcher) {
            mutableActions.emit(action)
        }
    }

    fun <ProxyState : Any> scope(
        initialState: ProxyState,
        reducer: ((ProxyState, Action) -> (ProxyState)),
        middlewares: List<Middleware<ProxyState>> = emptyList(),
    ): ProxyStore<ProxyState, State> = ProxyStore(
        middlewares = middlewares,
        initialState = initialState,
        reducer = reducer,
        parentStore = this,
        mainDispatcher = mainDispatcher
    )
}