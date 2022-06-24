package com.example.currencyexchangerates.domain.usecaseimpl

import com.example.currencyexchangerates.domain.model.DomainBookmark
import com.example.currencyexchangerates.domain.repository.LocalRepository
import com.example.currencyexchangerates.domain.usecases.BookmarkUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookmarkUseCaseImpl @Inject constructor(private val repository: LocalRepository) : BookmarkUseCase {
    override suspend fun saveBookmark(bookmark: DomainBookmark) {
        repository.saveBookmark(bookmark)
    }

    override suspend fun deleteBookmark(bookmark: DomainBookmark) {
        repository.deleteBookmark(bookmark)
    }

    override fun getBookmarks(): Flow<List<DomainBookmark>> {
        return repository.getData()
    }
}