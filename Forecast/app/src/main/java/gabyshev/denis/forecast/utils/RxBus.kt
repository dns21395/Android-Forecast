package gabyshev.denis.forecast.utils

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 * Created by Borya on 22.07.2017.
 */
class RxBus {
    private val bus = PublishSubject.create<Any>()

    fun send(event: Any) {
        bus.onNext(event)
    }

    fun toObservable(): Observable<Any> {
        return bus
    }

    fun hasObservers(): Boolean {
        return bus.hasObservers()
    }
}