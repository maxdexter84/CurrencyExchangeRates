package com.example.currencyexchangerates.domain.repository

import com.example.currencyexchangerates.ui.model.UICurrency
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    fun getData(): Flow<List<UICurrency>>
    suspend fun saveData(currencies: List<UICurrency>)
}