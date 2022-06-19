package com.example.currencyexchangerates.domain.usecases

import com.example.currencyexchangerates.domain.model.Currency
import com.example.currencyexchangerates.ui.model.UICurrency

interface SaveCurrenciesUseCase {
    suspend fun saveData(list: List<Currency>)
}