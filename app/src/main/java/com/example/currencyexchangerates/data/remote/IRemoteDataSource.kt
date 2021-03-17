package com.example.currencyexchangerates.data.remote

import com.example.currencyexchangerates.domen.common.LoadingResponse
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow

interface IRemoteDataSource {
    suspend fun getDataAsync(): LoadingResponse
}