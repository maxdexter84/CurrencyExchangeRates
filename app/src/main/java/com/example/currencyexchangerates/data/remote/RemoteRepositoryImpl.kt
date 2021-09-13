package com.example.currencyexchangerates.data.remote

import com.example.currencyexchangerates.domain.LoadingResponse
import com.example.currencyexchangerates.domain.ext.mapToUiCurrency
import com.example.currencyexchangerates.domain.repository.RemoteRepository
import java.io.IOException


class RemoteRepositoryImpl(private val api: ICurrencyApi) : RemoteRepository {
    override suspend fun getDataAsync(): LoadingResponse {
        return try {
            val res = api.getDataAsync().mapToUiCurrency()
            LoadingResponse.Success(res)
        } catch (e: IOException) {
            LoadingResponse.Failure(e.toString())
        }


    }
}