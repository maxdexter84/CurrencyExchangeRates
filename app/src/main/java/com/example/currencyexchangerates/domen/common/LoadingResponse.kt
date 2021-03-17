package com.example.currencyexchangerates.domen.common

import com.example.currencyexchangerates.data.entity.remoteCurrency.ResponseCBR

sealed class LoadingResponse {
    data class Success ( val data: ResponseCBR? = null): LoadingResponse()
    data class Failure(val error: String): LoadingResponse()

}

