package com.example.currencyexchangerates.data.entity.remoteCurrency

data class ResponseCBR (

	val date : String,
	val previousDate : String,
	val previousURL : String,
	val timestamp : String,
	val valute : Valute
)