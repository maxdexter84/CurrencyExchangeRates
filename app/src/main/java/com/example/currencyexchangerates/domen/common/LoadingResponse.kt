package com.example.currencyexchangerates.domen.common

import com.example.currencyexchangerates.data.entity.localeCurrency.DbCurrency

sealed class LoadingResponse {
    data class Success(val data: List<DbCurrency>): LoadingResponse()
    data class Failure(val error: String): LoadingResponse()

}

