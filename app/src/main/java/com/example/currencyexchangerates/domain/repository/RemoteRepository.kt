package com.example.currencyexchangerates.domain.repository

import com.example.currencyexchangerates.domain.model.Currency
import kotlinx.coroutines.flow.Flow

interface RemoteRepository {
    suspend fun getCurrencyList(symbol:String): Result<Currency>
}