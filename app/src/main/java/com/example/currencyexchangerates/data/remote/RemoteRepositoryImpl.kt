package com.example.currencyexchangerates.data.remote

import com.example.currencyexchangerates.domain.LoadingResponse
import com.example.currencyexchangerates.data.model.ext.mapToDbCurrency
import com.example.currencyexchangerates.domain.repository.RemoteRepository
import java.io.IOException


class RemoteRepositoryImpl(private val api: ICurrencyApi) : RemoteRepository {

    override suspend fun getDataAsync(): LoadingResponse {
        return try {
            LoadingResponse.Success(api.getDataAsync().mapToDbCurrency())
        } catch (e: IOException) {
            LoadingResponse.Failure(e.toString())
        }
    }
}