package com.example.currencyexchangerates.data.remote

import com.example.currencyexchangerates.data.LoadingResponse

interface IRemoteDataSource {
    suspend fun getDataAsync(): LoadingResponse
}