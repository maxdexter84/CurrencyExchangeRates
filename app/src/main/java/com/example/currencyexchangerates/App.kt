package com.example.currencyexchangerates

import android.app.Application
import android.util.Log
import androidx.work.Configuration
import androidx.work.WorkManager


class App : Application() {

    companion object {
        var preferences: AppPreferences? = null
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        preferences = AppPreferences(applicationContext)

        val myConfig = Configuration.Builder()
            .setMinimumLoggingLevel(Log.INFO)
            .build()

        WorkManager.initialize(this, myConfig)


    }


}