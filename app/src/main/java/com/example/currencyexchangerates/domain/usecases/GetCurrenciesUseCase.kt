package com.example.currencyexchangerates.domain.usecases

import com.example.currencyexchangerates.domain.LoadingResponse
import com.example.currencyexchangerates.domain.model.Currency
import com.example.currencyexchangerates.ui.model.UICurrency
import kotlinx.coroutines.flow.Flow

interface GetCurrenciesUseCase {
    suspend fun getRemoteData(): LoadingResponse
    fun getLocalData(): Flow<List<Currency>>
}