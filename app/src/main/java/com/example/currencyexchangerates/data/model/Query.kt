package com.example.currencyexchangerates.data.model

data class Query(
    val amount: Int,
    val from: String,
    val to: String
)