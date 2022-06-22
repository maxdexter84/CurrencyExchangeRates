package com.example.currencyexchangerates.ui.model

data class UIItemCurrency(val base: String, val shortName: String, val name: String, val value: String,
                          var isBookmark: Boolean = false) {
}