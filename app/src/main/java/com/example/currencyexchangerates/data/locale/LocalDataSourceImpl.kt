package com.example.currencyexchangerates.data.locale

import com.example.currencyexchangerates.data.entity.localeCurrency.Bookmark
import com.example.currencyexchangerates.data.entity.localeCurrency.DbCurrency
import com.example.currencyexchangerates.data.locale.dao.BookmarkDao
import com.example.currencyexchangerates.data.locale.dao.CurrencyDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class LocalDataSourceImpl(private val bookmarkDao: BookmarkDao, private val currencyDao: CurrencyDao): ILocalDataSource {
    override  fun getData(): Flow<List<DbCurrency>>  {
      return currencyDao.getCurrencies().flowOn(Dispatchers.IO)
    }

    override suspend fun saveData(currencies: List<DbCurrency>) {
        withContext(Dispatchers.IO){
            currencyDao.saveCurrency(*currencies.toTypedArray())
        }
    }

    override fun getBookmark(): Flow<List<Bookmark>> = flow {
        bookmarkDao.getBookmarks().flowOn(Dispatchers.IO)
    }


    override suspend fun saveBookmark(bookmark: Bookmark) {
        withContext(Dispatchers.IO){
            bookmarkDao.saveBookmark(bookmark)
        }
    }

    override suspend fun deleteBookmark(bookmark: Bookmark) {
        withContext(Dispatchers.IO){
            bookmarkDao.deleteBookmark(bookmark)
        }
    }
}