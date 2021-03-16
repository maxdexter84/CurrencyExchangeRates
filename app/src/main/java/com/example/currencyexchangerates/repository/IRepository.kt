package com.example.currencyexchangerates.repository

import com.example.currencyexchangerates.data.entity.localeCurrency.Bookmark
import com.example.currencyexchangerates.ui.entity.UICurrency
import kotlinx.coroutines.flow.Flow

interface IRepository {
    suspend fun getData(): Flow<List<UICurrency>>
    suspend fun saveData(currency: UICurrency)
    suspend fun getBookmark(): Flow<List<Bookmark>>
    suspend fun saveBookmark(bookmarkID: String)

}