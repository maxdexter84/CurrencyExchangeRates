package com.example.currencyexchangerates.data.entity.remoteCurrency

data class ResponseCBR(
    val Date: String,
    val PreviousDate: String,
    val PreviousURL: String,
    val Timestamp: String,
    val Valute: Valute
)