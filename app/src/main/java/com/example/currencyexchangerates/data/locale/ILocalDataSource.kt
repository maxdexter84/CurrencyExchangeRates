package com.example.currencyexchangerates.data.locale

import com.example.currencyexchangerates.data.entity.localeCurrency.Bookmark
import com.example.currencyexchangerates.data.entity.localeCurrency.DbCurrency
import com.example.currencyexchangerates.domen.common.LoadingResponse
import kotlinx.coroutines.Deferred

interface ILocalDataSource {
   suspend fun getDataAsync(): Deferred<LoadingResponse>
   suspend fun saveData(currency: DbCurrency)
   suspend fun getBookmarkAsync(): Deferred<List<Bookmark>>
   suspend fun saveBookmark(bookmark: Bookmark)

}