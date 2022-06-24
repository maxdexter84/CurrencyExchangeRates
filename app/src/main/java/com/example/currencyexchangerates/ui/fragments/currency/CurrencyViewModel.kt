package com.example.currencyexchangerates.ui.fragments.currency

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
import com.example.currencyexchangerates.ui.utils.Sort
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyViewModel @Inject constructor(
    private val getCurrenciesUseCase: GetCurrenciesUseCase,
    private val bookmarkUseCase: BookmarkUseCase,
    private val prefs: AppPreferences
) : ViewModel() {

    private val _currency = MutableStateFlow<UICurrency?>(null)
    val currency = _currency.asStateFlow()

    private val _currentList = MutableStateFlow<List<UIItemCurrency>?>(emptyList())
    val currentList = _currentList.asStateFlow()

    private val _error = MutableStateFlow("")
    val error = _error.asStateFlow()

    private val _loadingState = MutableStateFlow(false)
    val loadingState = _loadingState.asStateFlow()

    private val _currencyBookmarkList = MutableStateFlow<List<UIBookmark>?>(null)

    private val _searchViewList = MutableStateFlow<List<String>>(emptyList())
    val searchViewList = _searchViewList.asStateFlow()

    init {
        loadData()
        getBookmarks()
    }

    private fun getBookmarks() {
        viewModelScope.launch {
            bookmarkUseCase.getBookmarks().collect { list ->
                val res = list.map { it.mapToUIBookmark() }
                _currencyBookmarkList.value = res
            }
        }
    }

    fun saveSortedType(type: Int) {
        prefs.putSortedType(AppPreferences.SORTED_TYPE_KEY, type)
        getListBySortedType()
    }

    private fun getListBySortedType() {
        when (prefs.getSortedType(AppPreferences.SORTED_TYPE_KEY)) {
            Sort.VALUE_HIGH.type -> _currentList.value =
                _currentList.value?.sortedBy { it.value.toDouble() } ?: emptyList()
            Sort.VALUE_LOW.type -> _currentList.value =
                _currentList.value?.sortedByDescending { it.value.toDouble() } ?: emptyList()
            Sort.NAME_HIGH.type -> _currentList.value =
                _currentList.value?.sortedBy { it.shortName } ?: emptyList()
            Sort.NAME_LOW.type -> _currentList.value =
                _currentList.value?.sortedByDescending { it.shortName } ?: emptyList()
            else -> _currentList.value
        }
    }


    fun saveBookmark(item: UIItemCurrency) {
        viewModelScope.launch {
            if (item.isBookmark) {
                bookmarkUseCase.saveBookmark(item.mapToDomainBookmark())
            } else {
                bookmarkUseCase.deleteBookmark(item.mapToDomainBookmark())
            }

        }
    }

    fun loadData() {
        val symbol = getPreferencesCurrentCurrency().substringAfter('-').trim()
        _loadingState.value = true
        viewModelScope.launch {
            getCurrenciesUseCase.getRemoteData(symbol)
                .map {
                    it.convertToUICurrency(_currencyBookmarkList.value)
                }.onSuccess {
                    _currency.value = it
                    _currentList.value = it.listItem
                    _searchViewList.value =
                        it.listItem.map { currency -> "${currency.name} - ${currency.shortName}" }
                    _loadingState.value = false
                }.onFailure {
                    _error.value = it.message.toString()
                }
        }
    }

    fun getPreferencesCurrentCurrency(): String {
        return prefs.getCurrentCurrency(AppPreferences.CURRENT_CURRENCY_KEY)
            ?: AppPreferences.DEFAULT_CURRENCY
    }

    fun putPreferencesCurrentCurrency(index: Int) {
        prefs.putCurrentCurrency(AppPreferences.CURRENT_CURRENCY_KEY, _searchViewList.value[index])
    }

}