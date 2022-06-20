package com.example.currencyexchangerates.data.model.map

import com.example.currencyexchangerates.data.model.Rates
import com.example.currencyexchangerates.data.model.Symbols
import com.example.currencyexchangerates.data.model.SymbolsX
import kotlin.reflect.full.memberProperties

fun Rates.convertFromRatesToMap(): HashMap<String, String> {
    val map = HashMap<String, String>()
    for (property in Rates::class.memberProperties) {
        map[property.name] = property.getValue(this, property).toString()
    }
    return map
}

fun SymbolsX.convertToHashMap(): HashMap<String, String> {
    val map = HashMap<String, String>()
    for (property in SymbolsX::class.memberProperties) {
        map[property.name] = property.getValue(this, property) as String
    }
    return map
}