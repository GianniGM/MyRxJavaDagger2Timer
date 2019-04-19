package com.giannig.myrxjavatimer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), TimerView {

    @Inject
    lateinit var timerPresenter: TimerPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidInjection.inject(this)

        setContentView(R.layout.activity_main)
        timerButton.setOnClickListener {
            updateTimerText()
        }
    }

    private fun updateTimerText() {
        val seconds = inputTime.text.toString().toLongOrNull() ?: 0
        timerPresenter.updateTime(seconds)
    }

    override fun onStop() {
        super.onStop()
        timerPresenter.onStop()
    }

    override fun onStart() {
        super.onStart()
        timerPresenter.onStart(this)
    }

    override fun updateState(seconds: Long) {
        timerText.text = seconds.toString()
    }


    override fun stopTimer() {
        timerPresenter.stopTimer()
    }

}
