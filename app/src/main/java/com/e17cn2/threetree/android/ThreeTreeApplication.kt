package com.e17cn2.threetree.android

import android.app.Application
import android.util.Log
import com.e17cn2.threetree.android.data.di.dataModule
import com.e17cn2.threetree.android.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class ThreeTreeApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Log.d("ThreeTreeApplication", "Hello world")

        initTimber()
        initKoin()
    }

    private fun initKoin() {
        val modules =
            listOf(
                presentationModule,
                dataModule
            )

        startKoin {
            androidContext(this@ThreeTreeApplication)
            modules(modules)
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}