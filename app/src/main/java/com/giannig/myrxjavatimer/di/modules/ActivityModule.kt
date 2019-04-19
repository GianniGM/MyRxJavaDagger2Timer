package com.giannig.myrxjavatimer.di.modules

import com.giannig.myrxjavatimer.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * All activities intended to use Dagger2 @Inject should be listed here.
 */
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}

