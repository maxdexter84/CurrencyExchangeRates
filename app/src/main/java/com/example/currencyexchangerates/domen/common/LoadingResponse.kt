package com.example.currencyexchangerates.domen.common

sealed class LoadingResponse
    data class Success <T>(val data: T): LoadingResponse()
    data class Failure(val message: String): LoadingResponse()
