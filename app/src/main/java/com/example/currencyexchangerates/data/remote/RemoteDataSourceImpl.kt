package com.example.currencyexchangerates.data.remote

import com.example.currencyexchangerates.data.entity.ext.mapToDbCurrency
import com.example.currencyexchangerates.data.LoadingResponse
import java.io.IOException


class RemoteDataSourceImpl(private val api: ICurrencyApi): IRemoteDataSource {

    override suspend fun getDataAsync(): LoadingResponse {
      return try {
            LoadingResponse.Success(api.getDataAsync().mapToDbCurrency())
        }catch (e: IOException){
            LoadingResponse.Failure(e.toString())
        }
    }
}