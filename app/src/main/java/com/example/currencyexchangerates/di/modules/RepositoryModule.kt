package com.example.currencyexchangerates.di.modules

import com.example.currencyexchangerates.data.locale.LocalRepositoryImpl
import com.example.currencyexchangerates.data.remote.RemoteRepositoryImpl
import com.example.currencyexchangerates.domain.repository.LocalRepository
import com.example.currencyexchangerates.domain.repository.RemoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindLocalRepository(repository: LocalRepositoryImpl): LocalRepository

    @Binds
    abstract fun bindRemoteRepository(repository: RemoteRepositoryImpl): RemoteRepository
}