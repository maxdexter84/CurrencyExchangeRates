package com.example.currencyexchangerates.domain.usecaseimpl

import com.example.currencyexchangerates.domain.LoadingResponse
import com.example.currencyexchangerates.domain.repository.LocalRepository
import com.example.currencyexchangerates.domain.repository.RemoteRepository
import com.example.currencyexchangerates.domain.usecases.GetCurrenciesUseCase
import com.example.currencyexchangerates.ui.model.UICurrency
import kotlinx.coroutines.flow.Flow

class GetCurrenciesUseCaseImpl(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
) :
    GetCurrenciesUseCase {

    override suspend fun getRemoteData(): LoadingResponse {
       return remoteRepository.getDataAsync()
    }

    override suspend fun getLocalData(): Flow<List<UICurrency>> {
        return localRepository.getData()
    }
}