package com.example.currencyexchangerates.domain.usecaseimpl

import com.example.currencyexchangerates.domain.model.Currency
import com.example.currencyexchangerates.domain.repository.LocalRepository
import com.example.currencyexchangerates.domain.repository.RemoteRepository
import com.example.currencyexchangerates.domain.usecases.GetCurrenciesUseCase

class GetCurrenciesUseCaseImpl(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
) :
    GetCurrenciesUseCase {

    override suspend fun getRemoteData(symbol: String): Result<Currency> {
        return remoteRepository.getCurrencyList(symbol)
    }

//    override fun getLocalData(): Flow<List<Currency>> {
//        return localRepository.getData()
//    }
}