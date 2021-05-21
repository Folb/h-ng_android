package io.folb.h_ng

import android.app.Application
import io.folb.h_ng.di.AppComponent
import io.folb.h_ng.di.DaggerAppComponent


open class Application : Application() {
    val appComponent: AppComponent by lazy {
        initComponent()
    }

    open fun initComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        @Suppress("ControlFlowWithEmptyBody")
        if (BuildConfig.DEBUG) {
            //turn on debug log
        }
    }
}