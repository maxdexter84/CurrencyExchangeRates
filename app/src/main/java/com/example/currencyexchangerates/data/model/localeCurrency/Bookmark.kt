package com.example.currencyexchangerates.data.model.localeCurrency

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Bookmark(
    @PrimaryKey
    val id: String,
    val shortName: String,
    val base: String,
    val name: String,
    val value: String
)
