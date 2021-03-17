package com.example.currencyexchangerates.data.locale

import com.example.currencyexchangerates.data.entity.localeCurrency.Bookmark
import com.example.currencyexchangerates.data.entity.localeCurrency.DbCurrency
import com.example.currencyexchangerates.domen.common.LoadingResponse
import kotlinx.coroutines.Deferred

class LocalDataSourceImpl: ILocalDataSource {
    override suspend fun getDataAsync(): Deferred<LoadingResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveData(currency: DbCurrency) {
        TODO("Not yet implemented")
    }

    override suspend fun getBookmarkAsync(): Deferred<List<Bookmark>> {
        TODO("Not yet implemented")
    }

    override suspend fun saveBookmark(bookmark: Bookmark) {
        TODO("Not yet implemented")
    }
}