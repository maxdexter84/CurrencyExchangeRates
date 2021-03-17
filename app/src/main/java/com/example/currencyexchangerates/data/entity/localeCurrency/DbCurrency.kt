package com.example.currencyexchangerates.data.entity.localeCurrency

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency")
data class DbCurrency(
    @PrimaryKey
    val id : String,
    val date : String,
    val numCode : Int,
    val charCode : String,
    val nominal : Int,
    val name : String,
    val value : Double,
    val previous : Double
)

