package com.example.currencyexchangerates.domain.usecaseimpl

import com.example.currencyexchangerates.domain.model.Currency
import com.example.currencyexchangerates.domain.repository.LocalRepository
import com.example.currencyexchangerates.domain.usecases.SaveCurrenciesUseCase

class SaveCurrenciesUseCaseImpl(private val localRepository: LocalRepository) :
    SaveCurrenciesUseCase {
    override suspend fun saveData(list: List<Currency>) {
//        localRepository.saveData(list)
    }
}