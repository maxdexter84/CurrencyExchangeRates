package com.example.currencyexchangerates.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyexchangerates.App
import com.example.currencyexchangerates.AppPreferences
import com.example.currencyexchangerates.R
import com.example.currencyexchangerates.databinding.ActivityMainBinding
import com.example.currencyexchangerates.ui.fragments.currency.CurrencyFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val prefs: AppPreferences by lazy {
        App.preferences!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, CurrencyFragment.newInstance()).commit()

    }

    override fun onResume() {
        super.onResume()
        prefs.launches = prefs.launches.plus(1)
    }

}