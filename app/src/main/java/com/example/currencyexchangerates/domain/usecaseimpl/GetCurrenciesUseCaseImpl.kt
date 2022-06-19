package com.example.currencyexchangerates.domain.usecaseimpl

import com.example.currencyexchangerates.domain.LoadingResponse
import com.example.currencyexchangerates.domain.model.Currency
import com.example.currencyexchangerates.domain.repository.LocalRepository
import com.example.currencyexchangerates.domain.repository.RemoteRepository
import com.example.currencyexchangerates.domain.usecases.GetCurrenciesUseCase
import kotlinx.coroutines.flow.Flow

class GetCurrenciesUseCaseImpl(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
) :
    GetCurrenciesUseCase {

    override suspend fun getRemoteData(): LoadingResponse {
        return remoteRepository.getDataAsync()
    }

    override fun getLocalData(): Flow<List<Currency>> {
        return localRepository.getData()
    }
}