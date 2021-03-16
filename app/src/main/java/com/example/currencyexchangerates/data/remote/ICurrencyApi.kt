package com.example.currencyexchangerates.data.remote

import com.example.currencyexchangerates.data.entity.remoteCurrency.ResponseCBR
import retrofit2.Response
import retrofit2.http.GET
//https://www.cbr-xml-daily.ru/daily_json.js
interface ICurrencyApi {
    @GET("daily_json.js")
    fun getData(): Response<ResponseCBR>
}