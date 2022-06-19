package com.example.currencyexchangerates.domain.model

data class Currency(
    val id: String,
    val date: String,
    val charCode: String,
    val nominal: String,
    val name: String,
    val value: String,
    var bookmark: Boolean
)