package com.example.currencyexchangerates.ui.fragments.currency

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyexchangerates.AppPreferences
import com.example.currencyexchangerates.domain.usecases.BookmarkUseCase
import com.example.currencyexchangerates.domain.usecases.GetCurrenciesUseCase
import com.example.currencyexchangerates.ui.map.convertToUICurrency
import com.example.currencyexchangerates.ui.map.mapToDomainBookmark
import com.example.currencyexchangerates.ui.map.mapToUIBookmark
import com.example.currencyexchangerates.ui.model.UIBookmark
import com.example.currencyexchangerates.ui.model.UICurrency
import com.example.currencyexchangerates.ui.model.UIItemCurrency
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CurrencyViewModel(
    private val getCurrenciesUseCase: GetCurrenciesUseCase,
    private val bookmarkUseCase: BookmarkUseCase,
    private val prefs: AppPreferences
) : ViewModel() {

    private val _currencyList = MutableStateFlow<UICurrency?>(null)
    val currencyList = _currencyList.asStateFlow()

    private val _error = MutableStateFlow("")
    val error = _error.asStateFlow()

    private val _loadingState = MutableStateFlow(false)
    val loadingState = _error.asStateFlow()

    private val _currencyBookmarkList = MutableStateFlow<List<UIBookmark>?>(null)
    val currencyBookmarkList = _currencyBookmarkList.asStateFlow()


    init {
        startApp()
        getBookmarks()
    }

    fun startApp() {
//        val launch = prefs.launches
//        if (launch >= 1) {
//            getLocalData()
//        } else loadData("RUB")
        loadData("RUB")
    }

    private fun getBookmarks() {
        viewModelScope.launch {
            bookmarkUseCase.getBookmarks().collect{list->
                val res = list.map { it.mapToUIBookmark() }
                _currencyBookmarkList.value = res
            }
        }
    }


    fun saveBookmark(item: UIItemCurrency){
        viewModelScope.launch {
            if (item.isBookmark){
                bookmarkUseCase.saveBookmark(item.mapToDomainBookmark())
            } else {
                bookmarkUseCase.deleteBookmark(item.mapToDomainBookmark())
            }

        }
    }

    fun loadData(symbol: String) {
       _loadingState.value = true
        viewModelScope.launch {
            getCurrenciesUseCase.getRemoteData(symbol)
                .map {
                    it.convertToUICurrency(_currencyBookmarkList.value)
                }.onSuccess {
                    _currencyList.value = it
                    Log.i("UPLOAD_DATA_VIEWMODEL", "SUCSsESS")
                    _loadingState.value = false
                }.onFailure {
                    Log.i("UPLOAD_DATA_VIEWMODEL", it.message.toString())
                }
        }
    }
}