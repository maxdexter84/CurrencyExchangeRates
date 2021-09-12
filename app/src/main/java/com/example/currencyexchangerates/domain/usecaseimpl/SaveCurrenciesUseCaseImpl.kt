package com.example.currencyexchangerates.domain.usecaseimpl

import android.util.Log
import com.example.currencyexchangerates.domain.repository.LocalRepository
import com.example.currencyexchangerates.domain.usecases.SaveCurrenciesUseCase
import com.example.currencyexchangerates.ui.model.UICurrency

class SaveCurrenciesUseCaseImpl(private val localRepository: LocalRepository) : SaveCurrenciesUseCase {
    override suspend fun saveData(list: List<UICurrency>) {
        localRepository.saveData(list)
    }
}