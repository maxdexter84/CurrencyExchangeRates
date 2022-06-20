package com.example.currencyexchangerates.ui.model

import java.io.Serializable

data class UICurrency(
    val date: String,
    val base: String,
    val listItem: List<UIItemCurrency>
) : Serializable
