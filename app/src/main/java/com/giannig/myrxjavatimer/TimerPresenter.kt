package com.giannig.myrxjavatimer

import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TimerPresenter @Inject constructor(
    private val timerInteractor: TimerInteractor
) {
    private var disposable: Disposable? = null
    private lateinit var view: TimerView

    fun onStart(view: TimerView) {
        this.view = view
    }

    fun onStop() {
        if (disposable?.isDisposed == true)
            disposable?.dispose()
    }

    fun updateTime(seconds: Long) {
        disposable = timerInteractor
            .provideTimer(seconds)
            .observeOn(Schedulers.io())
            .subscribeOn(Schedulers.trampoline())
            .subscribe {
                view.updateState(it)
            }
    }

    fun stopTimer() {
        timerInteractor.stopTimer()
    }
}