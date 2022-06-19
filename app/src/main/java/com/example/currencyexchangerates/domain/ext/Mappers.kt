package com.example.currencyexchangerates.domain.ext

import com.example.currencyexchangerates.data.model.localeCurrency.DbCurrency
import com.example.currencyexchangerates.data.model.remoteCurrency.ResponseCBR
import com.example.currencyexchangerates.domain.model.Currency
import com.example.currencyexchangerates.ui.model.UICurrency

fun DbCurrency.mapToCurrency(): Currency {

    return this.let {
        Currency(
            id = it.id,
            date = it.date,
            charCode = it.charCode,
            nominal = it.nominal,
            name = it.name,
            value = it.value
        )
    }
}

fun UICurrency.mapToCurrency(): Currency {

    return this.let {
        Currency(
            id = it.id,
            date = it.date,
            charCode = it.charCode,
            nominal = it.nominal,
            name = it.name,
            value = it.value
        )
    }
}

fun ResponseCBR.mapToCurrency(): List<Currency> {
    val list = mutableListOf<Currency>()
    this.Valute.let {
        list.add(
            Currency(
                id = it.,
                date = Date,
                charCode = it.AUD.CharCode,
                nominal = it.AUD.Nominal.toString(),
                name = it.AUD.Name,
                value = it.AUD.Value.toString(),
                bookmark = false
            )
        )
    }
    return list
}


