package com.example.currencyexchangerates.domain.usecaseimpl

import com.example.currencyexchangerates.domain.repository.Repository
import com.example.currencyexchangerates.domain.usecases.GetCurrenciesUseCase
import com.example.currencyexchangerates.ui.entity.UICurrency
import kotlinx.coroutines.flow.Flow

class GetCurrenciesUseCaseImpl(private val repository: Repository) : GetCurrenciesUseCase {
    override suspend fun getData(): Flow<List<UICurrency>> {
       return repository.getData()
    }
}