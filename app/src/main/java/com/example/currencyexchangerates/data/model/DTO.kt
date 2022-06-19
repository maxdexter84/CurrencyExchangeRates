package com.example.currencyexchangerates.data.model

data class DTO(
    val base: String,
    val date: String,
    val rates: Rates,
    val success: Boolean,
    val timestamp: Int
)