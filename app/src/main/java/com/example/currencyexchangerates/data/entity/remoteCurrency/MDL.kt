package com.example.currencyexchangerates.data.entity.remoteCurrency

data class MDL (

	val iD : String,
	val numCode : Int,
	val charCode : String,
	val nominal : Int,
	val name : String,
	val value : Double,
	val previous : Double
)