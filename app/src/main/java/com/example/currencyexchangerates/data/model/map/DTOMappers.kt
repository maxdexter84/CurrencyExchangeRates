package com.example.currencyexchangerates.data.model.map

import com.example.currencyexchangerates.data.model.Rates
import com.example.currencyexchangerates.data.model.SymbolsX
import com.example.currencyexchangerates.data.model.localeCurrency.Bookmark
import com.example.currencyexchangerates.domain.model.DomainBookmark
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

fun Bookmark.mapToDomainBookmark(): DomainBookmark {
    return DomainBookmark(shortName, base, name, value)
}

fun DomainBookmark.mapToDatabaseBookmark(): Bookmark {
    val id = "$base$shortName"
    return Bookmark(id,shortName, base, name, value)
}