package com.example.currencyexchangerates.ui.fragments.bookmarks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyexchangerates.domain.usecases.BookmarkUseCase
import com.example.currencyexchangerates.ui.map.mapToDomainBookmark
import com.example.currencyexchangerates.ui.map.mapToUIBookmark
import com.example.currencyexchangerates.ui.model.UIBookmark
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class BookmarksViewModel @Inject constructor(private val bookmarkUseCase: BookmarkUseCase) : ViewModel() {

    private val _bookmarksList = MutableStateFlow<List<UIBookmark>>(emptyList())
    val bookmarksList = _bookmarksList.asStateFlow()

    private val _loadingState = MutableStateFlow(false)
    val loadingState = _loadingState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        _loadingState.value = true
        viewModelScope.launch {
            bookmarkUseCase.getBookmarks()
                .map { list ->
                    list.map { it.mapToUIBookmark() }
                }.collect {
                    _bookmarksList.value = it
                    _loadingState.value = false
                }
        }
    }

    fun deleteBookmark(bookmark: UIBookmark){
        viewModelScope.launch {
            bookmarkUseCase.deleteBookmark(bookmark.mapToDomainBookmark() )
        }
    }
}