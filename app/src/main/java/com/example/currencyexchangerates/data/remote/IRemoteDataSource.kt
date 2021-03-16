package com.example.currencyexchangerates.data.remote

import com.example.currencyexchangerates.domen.common.LoadingResponse
import kotlinx.coroutines.flow.Flow

interface IRemoteDataSource {
    fun getDataAsync(): Flow<LoadingResponse>
}