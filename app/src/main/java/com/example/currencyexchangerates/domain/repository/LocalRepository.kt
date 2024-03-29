package com.example.currencyexchangerates.domain.repository

import com.example.currencyexchangerates.domain.model.DomainBookmark
import com.example.currencyexchangerates.ui.model.UICurrency
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    fun getData(): Flow<List<DomainBookmark>>
    suspend fun saveBookmark(bookmark: DomainBookmark)
    suspend fun deleteBookmark(bookmark: DomainBookmark)
}