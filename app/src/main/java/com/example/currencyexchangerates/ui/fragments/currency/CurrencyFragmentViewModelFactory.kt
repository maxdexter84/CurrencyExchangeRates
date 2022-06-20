package com.example.currencyexchangerates.ui.fragments.currency

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.currencyexchangerates.AppPreferences
import com.example.currencyexchangerates.domain.usecases.GetCurrenciesUseCase
import com.example.currencyexchangerates.domain.usecases.SaveCurrenciesUseCase

class CurrencyFragmentViewModelFactory(
    private val getCurrenciesUseCase: GetCurrenciesUseCase,
    private val saveCurrenciesUseCase: SaveCurrenciesUseCase,
    private val prefs: AppPreferences
) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CurrencyViewModel(getCurrenciesUseCase, saveCurrenciesUseCase, prefs) as T
    }
}