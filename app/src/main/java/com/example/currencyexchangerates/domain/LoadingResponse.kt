package com.example.currencyexchangerates.domain

import com.example.currencyexchangerates.ui.model.UICurrency

sealed class LoadingResponse {
    data class Success(val data: List<UICurrency>) : LoadingResponse()
    data class Failure(val error: String) : LoadingResponse()
}

