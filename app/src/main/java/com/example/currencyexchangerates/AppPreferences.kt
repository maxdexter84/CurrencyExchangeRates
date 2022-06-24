package com.example.currencyexchangerates

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(context: Context) {
    private val preferences: SharedPreferences =
        context.getSharedPreferences("App_Pref", Context.MODE_PRIVATE)



    fun putSortedType(key: String, value: Int) {
        preferences.edit().putInt(key, value).apply()
    }

    fun getSortedType(key: String): Int {
        return preferences.getInt(key, DEFAULT_SORT_TYPE)
    }

    fun putCurrentCurrency(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }

    fun getCurrentCurrency(key: String): String? {
        return preferences.getString(key, DEFAULT_CURRENCY)
    }

    companion object {
        const val SORTED_TYPE_KEY = "SORTED_TYPE"
        const val DEFAULT_SORT_TYPE = 0
        const val DEFAULT_CURRENCY = "Russian Ruble - RUB"
        const val CURRENT_CURRENCY_KEY = "CURRENT_CURRENCY"
    }
}