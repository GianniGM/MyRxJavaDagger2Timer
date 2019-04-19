package com.giannig.myrxjavatimer.di.components

import android.app.Application
import com.giannig.myrxjavatimer.di.TimerApplication
import com.giannig.myrxjavatimer.di.modules.ActivityModule
import com.giannig.myrxjavatimer.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityModule::class])
interface TimerApplicationComponent {

    @Component.Builder
    interface Builder {
        // provide Application instance into DI
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): TimerApplicationComponent
    }

    // this is needed because LuaApp has @Inject
    fun inject(app: TimerApplication)
}