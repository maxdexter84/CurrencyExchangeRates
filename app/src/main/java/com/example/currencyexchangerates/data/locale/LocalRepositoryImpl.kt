package com.example.currencyexchangerates.data.locale

import com.example.currencyexchangerates.data.locale.dao.BookmarkDao
import com.example.currencyexchangerates.data.model.map.mapToDatabaseBookmark
import com.example.currencyexchangerates.data.model.map.mapToDomainBookmark
import com.example.currencyexchangerates.domain.model.DomainBookmark
import com.example.currencyexchangerates.domain.repository.LocalRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class LocalRepositoryImpl(
    private val bookmarkDao: BookmarkDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : LocalRepository {

    override fun getData(): Flow<List<DomainBookmark>> {
        return bookmarkDao.getBookmarks().map { list -> list.map { it.mapToDomainBookmark() } }
            .flowOn(dispatcher)
    }

    override suspend fun saveBookmark(bookmark: DomainBookmark) {
        withContext(dispatcher) {
            bookmark.let {
                bookmarkDao.saveBookmark(bookmark.mapToDatabaseBookmark())
            }
        }
    }

    override suspend fun deleteBookmark(bookmark: DomainBookmark) {
        withContext(dispatcher) {
            bookmarkDao.deleteBookmark(bookmark.mapToDatabaseBookmark())
        }
    }

}