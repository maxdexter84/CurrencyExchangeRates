package com.example.currencyexchangerates

import android.app.Application


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
    }
}