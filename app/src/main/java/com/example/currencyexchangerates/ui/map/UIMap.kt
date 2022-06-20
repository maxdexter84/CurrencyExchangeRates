package com.example.currencyexchangerates.ui.map

import com.example.currencyexchangerates.domain.model.Currency
import com.example.currencyexchangerates.ui.model.UICurrency
import com.example.currencyexchangerates.ui.model.UIItemCurrency

fun Currency.convertToUICurrencyList(): UICurrency {
    return UICurrency(this.date, this.base, convertRatesMapToUIItemCurrency(this.rates, this.symbols))
}

private fun convertRatesMapToUIItemCurrency(valueMap: HashMap<String, String>, symbolsMap: HashMap<String, String>): List<UIItemCurrency> {
    return valueMap.map {
        UIItemCurrency(it.key,symbolsMap[it.key] ?: "", it.value )
    }.toList()
}