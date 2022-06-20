package com.example.currencyexchangerates.data.remote

import android.util.Log
import com.example.currencyexchangerates.data.model.map.convertFromRatesToMap
import com.example.currencyexchangerates.data.model.map.convertToHashMap
import com.example.currencyexchangerates.domain.model.Currency
import com.example.currencyexchangerates.domain.repository.RemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteRepositoryImpl(private val api: ICurrencyApi) : RemoteRepository {

    override suspend fun getCurrencyList(symbol: String): Result<Currency> {
        return runCatching {
            val dto = api.getCurrencyList(symbol)
            val symb = api.getSymbols()
            Currency(
                dto.base,
                dto.date,
                dto.rates.convertFromRatesToMap(),
                symb.symbols.convertToHashMap()
            )
        }.onSuccess {
            Result.success(it)
            Log.i("UPLOAD_DATA_REPOSITORY", "SUCSsESS")
        }.onFailure {
            Result.failure<Throwable>(it)
            Log.i("UPLOAD_DATA_REPOSITORY", it.message.toString())
        }
    }
}