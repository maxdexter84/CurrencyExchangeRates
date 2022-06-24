package com.example.currencyexchangerates.ui.map

import com.example.currencyexchangerates.domain.model.Currency
import com.example.currencyexchangerates.domain.model.DomainBookmark
import com.example.currencyexchangerates.ui.model.UIBookmark
import com.example.currencyexchangerates.ui.model.UICurrency
import com.example.currencyexchangerates.ui.model.UIItemCurrency

fun Currency.convertToUICurrency(list: List<UIBookmark>?): UICurrency {
    return UICurrency(
        this.date,
        this.base,
        convertRatesMapToUIItemCurrency(this.rates, this.symbols, this.base, list)
    )
}

private fun convertRatesMapToUIItemCurrency(
    valueMap: HashMap<String, String>,
    symbolsMap: HashMap<String, String>,
    base: String,
    list: List<UIBookmark>?
): List<UIItemCurrency> {

    return valueMap.map {
        var isBookmark = false
        list?.forEach { bookmark ->
            if (bookmark.base == base && bookmark.shortName == it.key) isBookmark = true
        }
        UIItemCurrency(
            base = base,
            it.key,
            symbolsMap[it.key] ?: "",
            it.value,
            isBookmark = isBookmark
        )
    }.toList()
}

fun UIItemCurrency.mapToDomainBookmark(): DomainBookmark {
    return DomainBookmark(
        base = this.base,
        shortName = this.shortName,
        name = this.shortName,
        value = this.value
    )
}

fun DomainBookmark.mapToUIBookmark(): UIBookmark {
    return UIBookmark(shortName, base, name, value)
}

fun UIBookmark.mapToDomainBookmark(): DomainBookmark {
    return DomainBookmark(shortName, base, name, value)
}

