package com.example.currencyexchangerates.data.remote

import com.example.currencyexchangerates.domen.common.LoadingResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import retrofit2.http.HTTP
import java.io.IOException


class RemoteDataSourceImpl(private val api: ICurrencyApi = CurrencyApi.currencyService): IRemoteDataSource {
    override fun getDataAsync(): Flow<LoadingResponse> = flow{
        try {
            val result = api.getData()
            when(result.isSuccessful){
                true -> emit(LoadingResponse.Success(result.body()))
                false -> emit(LoadingResponse.Failure(result.code().toString()))
            }
        }catch (e: IOException){
            emit(LoadingResponse.Failure(e.message.toString()))
        }
    }
}