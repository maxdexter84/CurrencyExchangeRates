package com.example.currencyexchangerates.data.locale.dao

import androidx.room.*
import com.example.currencyexchangerates.data.model.localeCurrency.DbCurrency
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCurrency(list: List<DbCurrency>)

    @Query("SELECT * FROM currency")
    fun getCurrencies(): Flow<List<DbCurrency>>

//    @Transaction
//    suspend fun saveCurrenciesList(list: List<DbCurrency>){
//        list.forEach { saveCurrency(it) }
//    }
}