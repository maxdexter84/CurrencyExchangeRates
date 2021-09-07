package com.example.currencyexchangerates.data.remote

import com.example.currencyexchangerates.data.model.remoteCurrency.ResponseCBR
import retrofit2.http.GET

interface ICurrencyApi {
    @GET("daily_json.js")
    suspend fun getDataAsync(): ResponseCBR
}