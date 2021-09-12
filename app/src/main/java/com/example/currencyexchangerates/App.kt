package com.example.currencyexchangerates

import android.app.Application
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.currencyexchangerates.data.worker.CurrencyLoadWorker
import java.util.concurrent.TimeUnit


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



        val myWork = PeriodicWorkRequestBuilder<CurrencyLoadWorker>(24, TimeUnit.HOURS).build()
        WorkManager.getInstance(this)
            .enqueueUniquePeriodicWork("Load Data Work", ExistingPeriodicWorkPolicy.KEEP, myWork)
    }
}