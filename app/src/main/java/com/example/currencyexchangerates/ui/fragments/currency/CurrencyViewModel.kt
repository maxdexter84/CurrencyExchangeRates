package com.example.currencyexchangerates.ui.fragments.currency

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyexchangerates.domain.LoadingResponse
import com.example.currencyexchangerates.domain.usecases.GetCurrenciesUseCase
import com.example.currencyexchangerates.domain.usecases.SaveCurrenciesUseCase
import com.example.currencyexchangerates.ui.model.UICurrency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CurrencyViewModel(
    private val getCurrenciesUseCase: GetCurrenciesUseCase,
    private val saveCurrenciesUseCase: SaveCurrenciesUseCase
) : ViewModel() {

    private val _currencyList = MutableLiveData<List<UICurrency>>(emptyList())
    val currencyList: LiveData<List<UICurrency>>
        get() = _currencyList

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    init {
        loadData()
    }

    private fun getLocalData() {
        viewModelScope.launch {
            getCurrenciesUseCase.getLocalData().collect {
                _currencyList.value = it
            }
        }
    }

    fun loadData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                delay(100)
                val result = getCurrenciesUseCase.getRemoteData()
                parseResult(result)
            }
        }
    }

    private fun parseResult(result: LoadingResponse) {
        when (result) {
            is LoadingResponse.Success -> saveData(result.data)
            is LoadingResponse.Failure -> _error.value = result.error
        }
    }

    private fun saveData(list: List<UICurrency>) {
        viewModelScope.launch {
            saveCurrenciesUseCase.saveData(list)
        }
    }
}