package com.example.currencyexchangerates.data.entity.remoteCurrency

data class TJS (
	val iD : String,
	val numCode : Int,
	val charCode : String,
	val nominal : Int,
	val name : String,
	val value : Double,
	val previous : Double
)