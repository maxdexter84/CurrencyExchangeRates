package com.example.currencyexchangerates.domain.usecases

import com.example.currencyexchangerates.ui.entity.UICurrency
import kotlinx.coroutines.flow.Flow

interface GetCurrenciesUseCase {
    suspend fun getData(): Flow<List<UICurrency>>
}