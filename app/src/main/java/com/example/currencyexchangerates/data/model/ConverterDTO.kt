package com.example.currencyexchangerates.data.model

data class ConverterDTO(
    val date: String,
    val info: Info,
    val query: Query,
    val result: Double,
    val success: Boolean
)