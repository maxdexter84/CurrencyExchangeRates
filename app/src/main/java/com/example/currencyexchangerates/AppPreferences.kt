package com.example.currencyexchangerates

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(context: Context) {
    private val preferences: SharedPreferences =
        context.getSharedPreferences("App_Pref", Context.MODE_PRIVATE)

    var launches: Int
        get() = preferences.getInt(NUMBER_OF_LAUNCHES, 0)
        set(value) = preferences.edit().putInt(NUMBER_OF_LAUNCHES, value).apply()

    companion object {
        const val NUMBER_OF_LAUNCHES = "NUMBER_OF_LAUNCHES"
    }
}