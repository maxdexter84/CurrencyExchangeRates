package com.example.currencyexchangerates.domain.repository

import com.example.currencyexchangerates.domain.LoadingResponse

interface RemoteRepository {
    suspend fun getDataAsync(): LoadingResponse
}