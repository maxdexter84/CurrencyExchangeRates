package com.example.currencyexchangerates.data.remote

import com.example.currencyexchangerates.data.remote.CurrencyApi.KEY
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val BASE_URL = "https://api.apilayer.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val requestInterceptor = Interceptor {chain ->
    val url = chain.request()
        .url
        .newBuilder()
        .addQueryParameter("apikey", KEY)
        .build()
    val request = chain.request()
        .newBuilder()
        .url(url)
        .build()
    return@Interceptor chain.proceed(request)
}
private val okHttpClient = OkHttpClient.Builder()
    .addInterceptor(requestInterceptor)
    .build()

private val retrofit = Retrofit.Builder()
    .client(okHttpClient)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

object CurrencyApi {
    val currencyService: ICurrencyApi by lazy {
        retrofit.create(ICurrencyApi::class.java)
    }
    const val KEY = "FH3rZC4FpCrYj99uTvnYA0A86O5g3qhe"
}

