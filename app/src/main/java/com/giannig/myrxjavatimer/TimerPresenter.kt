package com.giannig.myrxjavatimer

import com.giannig.myrxjavatimer.extensions.subscribeOrLog
import io.reactivex.android.schedulers.AndroidSchedulers
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
            .provideTimer(MILLI * seconds)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOrLog(TAG) {
                view.updateState(it)
            }
    }

    fun stopTimer() {
        timerInteractor.stopTimer()
    }

    companion object {
        private const val TAG = "TIMER_PRESENTER"
        private const val MILLI = 1_000
    }
}

