package com.example.currencyexchangerates.data.entity.localeCurrency

data class dbCurrency(
    val iD : String,
    val date : String,
    val numCode : Int,
    val charCode : String,
    val nominal : Int,
    val name : String,
    val value : Double,
    val previous : Double
)

