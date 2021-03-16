package com.example.currencyexchangerates.domen.`interface`

import com.example.currencyexchangerates.data.entity.localeCurrency.DbCurrency
import com.example.currencyexchangerates.domen.common.LoadingResponse
import kotlinx.coroutines.Deferred

interface ILocalDataSource {
   suspend fun getDataAsync(): Deferred<LoadingResponse>
   suspend fun saveData(currency: DbCurrency)
   suspend fun updateData(currencyId: String, isBookmark: Boolean)
   suspend fun getBookmark()

}