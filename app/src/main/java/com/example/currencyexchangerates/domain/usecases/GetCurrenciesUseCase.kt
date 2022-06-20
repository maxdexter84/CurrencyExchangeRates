package com.example.currencyexchangerates.domain.usecases

import com.example.currencyexchangerates.domain.model.Currency

interface GetCurrenciesUseCase {
    suspend fun getRemoteData(symbol: String): Result<Currency>
    // fun getLocalData(): Flow<List<Currency>>
}