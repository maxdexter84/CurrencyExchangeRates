package com.example.currencyexchangerates.ui.model

import java.io.Serializable

data class UICurrency(
    val id: String,
    val date: String,
    val charCode: String,
    val nominal: String,
    val name: String,
    val value: String
) : Serializable
