package com.example.currencyexchangerates.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.currencyexchangerates.App
import com.example.currencyexchangerates.AppPreferences
import com.example.currencyexchangerates.R
import com.example.currencyexchangerates.data.worker.CurrencyLoadWorker
import com.example.currencyexchangerates.databinding.ActivityMainBinding
import com.example.currencyexchangerates.ui.fragments.currency.CurrencyFragment
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val prefs: AppPreferences by lazy {
        App.preferences!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val myWork = PeriodicWorkRequestBuilder<CurrencyLoadWorker>(24, TimeUnit.HOURS).build()
       WorkManager.getInstance(this)
            .enqueueUniquePeriodicWork("Load Data Work", ExistingPeriodicWorkPolicy.KEEP, myWork).state.observe(this,{
                Log.i("WORKER", it.toString())
           })
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, CurrencyFragment.newInstance()).commit()

    }

    override fun onResume() {
        super.onResume()
        prefs.launches = prefs.launches.plus(1)
    }

}