package com.example.currencyexchangerates.domain.model

data class Currency(
    val base: String,
    val date: String,
    val rates: HashMap<String, String>,
    val symbols: HashMap<String, String>
)