package com.example.currencyexchangerates.data.locale

import com.example.currencyexchangerates.data.entity.localeCurrency.Bookmark
import com.example.currencyexchangerates.data.entity.localeCurrency.DbCurrency
import com.example.currencyexchangerates.domen.common.LoadingResponse
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow

interface ILocalDataSource {
    fun getData(): Flow<List<DbCurrency>>
   suspend fun saveData(currencies: List<DbCurrency>)
    fun getBookmark(): Flow<List<Bookmark>>
   suspend fun saveBookmark(bookmark: Bookmark)
   suspend fun deleteBookmark(bookmark: Bookmark)

}