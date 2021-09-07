package com.example.currencyexchangerates.data

import com.example.currencyexchangerates.domain.repository.LocalRepository
import com.example.currencyexchangerates.domain.repository.RemoteRepository

class RepositoryImpl(
    private val remoteSource: RemoteRepository,
    private val localSource: LocalRepository
) {

//    override suspend fun getData(): Flow<List<UICurrency>> {
//        return when (val res = remoteSource.getDataAsync()) {
//            is LoadingResponse.Success -> {
//                val arr = res.data
//                saveData(arr)
//                localSource.getData().map { it.map { dbCurrency -> dbCurrency.mapToUICurrency() } }
//            }
//            is LoadingResponse.Failure -> {
//                localSource.getData().map { it.map { dbCurrency -> dbCurrency.mapToUICurrency() } }
//            }
//        }
//    }
//
//    override suspend fun saveData(list: List<DbCurrency>?) {
//        if (list != null)
//            localSource.saveData(list)
//    }
//
//    override suspend fun getBookmark(): Flow<List<Bookmark>> {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun saveBookmark(bookmarkID: String) {
//        TODO("Not yet implemented")
//    }
}