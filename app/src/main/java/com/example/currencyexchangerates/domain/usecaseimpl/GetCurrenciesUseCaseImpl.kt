package com.example.currencyexchangerates.domain.usecaseimpl

import com.example.currencyexchangerates.domain.model.Currency
import com.example.currencyexchangerates.domain.repository.RemoteRepository
import com.example.currencyexchangerates.domain.usecases.GetCurrenciesUseCase
import javax.inject.Inject

class GetCurrenciesUseCaseImpl @Inject constructor(
    private val remoteRepository: RemoteRepository,
) :
    GetCurrenciesUseCase {

    override suspend fun getRemoteData(symbol: String): Result<Currency> {
        return remoteRepository.getCurrencyList(symbol)
    }
}