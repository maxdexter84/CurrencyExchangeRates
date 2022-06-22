package com.example.currencyexchangerates.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavHost
import androidx.navigation.ui.setupWithNavController
import com.example.currencyexchangerates.App
import com.example.currencyexchangerates.AppPreferences
import com.example.currencyexchangerates.R
import com.example.currencyexchangerates.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val prefs: AppPreferences by lazy {
        App.preferences!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val myWork = PeriodicWorkRequestBuilder<CurrencyLoadWorker>(10, TimeUnit.HOURS).build()
//        WorkManager.getInstance(this)
//            .enqueueUniquePeriodicWork(
//                "Load Data Work",
//                ExistingPeriodicWorkPolicy.KEEP,
//                myWork
//            ).state.observe(this, {
//                Log.i("WORKER", it.toString())
//            })
        val navHost = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHost
        val navView: BottomNavigationView = binding.bottomNav

        val navController = navHost.navController
        navView.setupWithNavController(navController)


    }

    override fun onResume() {
        super.onResume()
        prefs.launches = prefs.launches.plus(1)

    }

}