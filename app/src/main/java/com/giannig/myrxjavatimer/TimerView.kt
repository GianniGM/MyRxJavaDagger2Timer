package com.giannig.myrxjavatimer

interface TimerView {
    fun updateState(seconds: Long)
    fun stopTimer()
}