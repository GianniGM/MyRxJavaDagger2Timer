package com.giannig.myrxjavatimer.di.modules

import com.giannig.myrxjavatimer.TimerInteractor
import com.giannig.myrxjavatimer.TimerPresenter
import dagger.Module
import dagger.Provides

/**
 * AppModule shall be used initialize
 * objects used across our application, such as Room(Database),
 * Retrofit, Shared Preference, etc.
 */
@Module
internal class AppModule {

    @Provides
    fun providePresenter(timerInteractor: TimerInteractor) = TimerPresenter(timerInteractor)

}