package com.example.currencyexchangerates.data.locale

import com.example.currencyexchangerates.data.locale.dao.CurrencyDao
import com.example.currencyexchangerates.domain.repository.LocalRepository
import com.example.currencyexchangerates.ui.model.UICurrency
import kotlinx.coroutines.flow.Flow

class LocalRepositoryImpl(
    private val currencyDao: CurrencyDao
) : LocalRepository {
    //    override fun getData(): Flow<List<Currency>> {
//        return currencyDao.getCurrencies().map { list -> list.map { it.mapToCurrency() } }
//            .flowOn(Dispatchers.IO)
//    }
//
//    override suspend fun saveData(currencies: List<Currency>) {
//        withContext(Dispatchers.IO) {
//            currencyDao.saveCurrency(currencies.map { it.mapToDBCurrency() })
//        }
//    }
    override fun getData(): Flow<List<UICurrency>> {
        TODO("Not yet implemented")
    }

    override suspend fun saveData(currencies: List<UICurrency>) {
        TODO("Not yet implemented")
    }
}