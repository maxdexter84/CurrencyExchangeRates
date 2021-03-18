package com.example.currencyexchangerates.repository

import com.example.currencyexchangerates.data.entity.ext.mapToUICurrency
import com.example.currencyexchangerates.data.entity.localeCurrency.Bookmark
import com.example.currencyexchangerates.data.entity.localeCurrency.DbCurrency
import com.example.currencyexchangerates.data.locale.ILocalDataSource
import com.example.currencyexchangerates.data.remote.IRemoteDataSource
import com.example.currencyexchangerates.data.LoadingResponse
import com.example.currencyexchangerates.ui.entity.UICurrency
import kotlinx.coroutines.flow.*

class RepositoryImpl(private val remoteSource: IRemoteDataSource, private val localSource: ILocalDataSource): IRepository {

    override suspend fun getData(): Flow<List<UICurrency>>  {
       return when(val res = remoteSource.getDataAsync()){
             is LoadingResponse.Success -> {
                 val arr = res.data
                 saveData(arr)
                 localSource.getData().map { it.map { dbCurrency -> dbCurrency.mapToUICurrency() } }
             }
             is LoadingResponse.Failure -> {
                localSource.getData().map { it.map { dbCurrency -> dbCurrency.mapToUICurrency() } }
             }
         }
    }

    override suspend fun saveData(list: List<DbCurrency>?) {
            if (list != null)
            localSource.saveData(list)
    }

    override suspend fun getBookmark(): Flow<List<Bookmark>> {
        TODO("Not yet implemented")
    }

    override suspend fun saveBookmark(bookmarkID: String) {
        TODO("Not yet implemented")
    }
}