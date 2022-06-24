package com.example.currencyexchangerates.di.modules

import com.example.currencyexchangerates.data.remote.CurrencyApi
import com.example.currencyexchangerates.data.remote.ICurrencyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideCurrencyApi(): ICurrencyApi {
        return CurrencyApi.currencyService
    }
}