package com.example.currencyexchangerates.domain.repository

import com.example.currencyexchangerates.data.model.localeCurrency.Bookmark
import com.example.currencyexchangerates.data.model.localeCurrency.DbCurrency
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    fun getData(): Flow<List<DbCurrency>>
    suspend fun saveData(currencies: List<DbCurrency>)
    fun getBookmark(): Flow<List<Bookmark>>
    suspend fun saveBookmark(bookmark: Bookmark)
    suspend fun deleteBookmark(bookmark: Bookmark)

}