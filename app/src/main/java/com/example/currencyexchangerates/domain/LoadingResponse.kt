package com.example.currencyexchangerates.domain

import com.example.currencyexchangerates.data.model.localeCurrency.DbCurrency

sealed class LoadingResponse {
    data class Success(val data: List<DbCurrency>) : LoadingResponse()
    data class Failure(val error: String) : LoadingResponse()

}

