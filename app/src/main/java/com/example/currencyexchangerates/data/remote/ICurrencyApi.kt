package com.example.currencyexchangerates.data.remote

import com.example.currencyexchangerates.data.model.DTO
import com.example.currencyexchangerates.data.model.Symbols
import retrofit2.http.GET
import retrofit2.http.Query

interface ICurrencyApi {
    @GET("/exchangerates_data/latest?")
    suspend fun getCurrencyList(@Query("base") base: String): DTO

    @GET("/exchangerates_data/symbols?")
    suspend fun getSymbols(): Symbols
}