package com.giannig.myrxjavatimer

import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class TimerInteractor @Inject constructor() {
    private val observable = Observable.interval(0, 1, TimeUnit.MILLISECONDS)

    fun provideTimer(seconds: Long): Observable<Long> {
        return observable
            .take(seconds + 1)
            .map {
                seconds - it
            }
    }

    fun stopTimer() {
    }

}