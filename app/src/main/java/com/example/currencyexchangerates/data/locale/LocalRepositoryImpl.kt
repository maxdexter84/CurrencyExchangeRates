package com.example.currencyexchangerates.data.locale

import com.example.currencyexchangerates.data.locale.dao.CurrencyDao
import com.example.currencyexchangerates.domain.ext.mapToDBCurrency
import com.example.currencyexchangerates.domain.ext.mapToUICurrency
import com.example.currencyexchangerates.domain.repository.LocalRepository
import com.example.currencyexchangerates.ui.model.UICurrency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.withContext

class LocalRepositoryImpl(
    private val currencyDao: CurrencyDao
) : LocalRepository {
    @ExperimentalCoroutinesApi
    override fun getData(): Flow<List<UICurrency>> {
        return currencyDao.getCurrencies().mapLatest { list -> list.map { it.mapToUICurrency() } }
            .flowOn(Dispatchers.IO)
    }

    override suspend fun saveData(currencies: List<UICurrency>) {
        withContext(Dispatchers.IO) {
            currencyDao.saveCurrency(currencies.map { it.mapToDBCurrency() })
        }
    }
}