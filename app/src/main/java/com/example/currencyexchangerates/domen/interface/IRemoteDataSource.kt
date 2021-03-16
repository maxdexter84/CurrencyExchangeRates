package com.example.currencyexchangerates.domen.`interface`

import com.example.currencyexchangerates.domen.common.LoadingResponse
import kotlinx.coroutines.Deferred

interface IRemoteDataSource {
    fun getData(): Deferred<LoadingResponse>
}