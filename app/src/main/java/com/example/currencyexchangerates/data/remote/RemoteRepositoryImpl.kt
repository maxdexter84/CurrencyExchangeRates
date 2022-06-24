package com.example.currencyexchangerates.data.remote

import com.example.currencyexchangerates.data.model.map.convertFromRatesToMap
import com.example.currencyexchangerates.data.model.map.convertToHashMap
import com.example.currencyexchangerates.domain.model.Currency
import com.example.currencyexchangerates.domain.repository.RemoteRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val api: ICurrencyApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : RemoteRepository {

    override suspend fun getCurrencyList(symbol: String): Result<Currency> {
        return runCatching {
            withContext(dispatcher) {
                val dto = api.getCurrencyList(symbol)
                val symb = api.getSymbols()
                Currency(
                    dto.base,
                    dto.date,
                    dto.rates.convertFromRatesToMap(),
                    symb.symbols.convertToHashMap()
                )
            }
        }.onSuccess {
            Result.success(it)
        }.onFailure {
            Result.failure<Throwable>(it)
        }
    }
}