package com.example.currencyexchangerates.repository

import com.example.currencyexchangerates.data.entity.ext.mapToUICurrency
import com.example.currencyexchangerates.data.entity.localeCurrency.Bookmark
import com.example.currencyexchangerates.data.locale.ILocalDataSource
import com.example.currencyexchangerates.data.remote.IRemoteDataSource
import com.example.currencyexchangerates.domen.common.LoadingResponse
import com.example.currencyexchangerates.ui.entity.UICurrency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class RepositoryImpl(private val remoteSource: IRemoteDataSource, private val localSource: ILocalDataSource): IRepository {

    override suspend fun getData(): List<UICurrency>? {
         return when(val res = remoteSource.getDataAsync()){
             is LoadingResponse.Success -> {
                 res.data?.mapToUICurrency() 
             }
             is LoadingResponse.Failure -> {
                 emptyList()
             }
         }
    }

    override suspend fun saveData(currency: UICurrency) {
        TODO("Not yet implemented")
    }

    override suspend fun getBookmark(): Flow<List<Bookmark>> {
        TODO("Not yet implemented")
    }

    override suspend fun saveBookmark(bookmarkID: String) {
        TODO("Not yet implemented")
    }
}