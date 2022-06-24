package com.example.currencyexchangerates.di.modules

import com.example.currencyexchangerates.domain.usecaseimpl.BookmarkUseCaseImpl
import com.example.currencyexchangerates.domain.usecaseimpl.GetCurrenciesUseCaseImpl
import com.example.currencyexchangerates.domain.usecases.BookmarkUseCase
import com.example.currencyexchangerates.domain.usecases.GetCurrenciesUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindBookmarkUseCase(useCase: BookmarkUseCaseImpl): BookmarkUseCase

    @Binds
    abstract fun bindCurrencyUseCase(useCase: GetCurrenciesUseCaseImpl): GetCurrenciesUseCase
}