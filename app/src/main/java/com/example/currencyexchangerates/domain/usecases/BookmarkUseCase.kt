package com.example.currencyexchangerates.domain.usecases

import com.example.currencyexchangerates.domain.model.DomainBookmark
import kotlinx.coroutines.flow.Flow

interface BookmarkUseCase {
    suspend fun saveBookmark(bookmark: DomainBookmark)
    suspend fun deleteBookmark(bookmark: DomainBookmark)
    fun getBookmarks(): Flow<List<DomainBookmark>>
}