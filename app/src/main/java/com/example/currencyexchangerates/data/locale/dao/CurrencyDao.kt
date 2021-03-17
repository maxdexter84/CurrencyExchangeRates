package com.example.currencyexchangerates.data.locale.dao

import androidx.room.*
import com.example.currencyexchangerates.data.entity.localeCurrency.DbCurrency
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCurrency(currency: DbCurrency)

    @Query("SELECT * FROM currency")
    fun getCurrencies(): Flow<List<DbCurrency>>

    @Transaction
    suspend fun saveCurrenciesList(list: List<DbCurrency>){
        for (dbCurrency in list) {
            saveCurrency(dbCurrency)
        }
    }
}