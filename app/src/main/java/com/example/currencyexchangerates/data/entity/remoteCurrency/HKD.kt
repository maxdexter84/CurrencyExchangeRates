package com.example.currencyexchangerates.data.entity.remoteCurrency

data class HKD(
    val CharCode: String,
    val ID: String,
    val Name: String,
    val Nominal: Int,
    val NumCode: String,
    val Previous: Double,
    val Value: Double
)