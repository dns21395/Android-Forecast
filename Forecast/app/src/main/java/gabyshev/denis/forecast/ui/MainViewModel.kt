package gabyshev.denis.forecast.ui

import androidx.lifecycle.ViewModel
import gabyshev.denis.forecast.core.store.AppStore
import javax.inject.Inject

class MainViewModel @Inject constructor(
    appStore: AppStore,
) : ViewModel() {

    init {
        appStore.wire()
    }
}