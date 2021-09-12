package com.example.currencyexchangerates.ui.fragments.currency

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyexchangerates.AppPreferences
import com.example.currencyexchangerates.domain.LoadingResponse
import com.example.currencyexchangerates.domain.usecases.GetCurrenciesUseCase
import com.example.currencyexchangerates.domain.usecases.SaveCurrenciesUseCase
import com.example.currencyexchangerates.ui.model.UICurrency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CurrencyViewModel(
    private val getCurrenciesUseCase: GetCurrenciesUseCase,
    private val saveCurrenciesUseCase: SaveCurrenciesUseCase,
    private val prefs: AppPreferences
) : ViewModel() {

    private val _currencyList = MutableLiveData<List<UICurrency>>(emptyList())
    val currencyList: LiveData<List<UICurrency>>
        get() = _currencyList

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    init {
        startApp()

    }

    fun startApp() {
        val launch = prefs.launches
        if (launch >= 1) {
            getLocalData()
        } else loadData()
    }

    private fun getLocalData() {
        viewModelScope.launch {
            getCurrenciesUseCase.getLocalData().collect {
                _currencyList.value = it
            }
        }
    }

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getCurrenciesUseCase.getRemoteData()
            withContext(Dispatchers.Main) {
                parseResult(result)
            }
        }
    }

    private fun parseResult(result: LoadingResponse) {
        when (result) {
            is LoadingResponse.Success -> {
                _currencyList.value = emptyList()
                saveData(result.data)
                getLocalData()
            }
            is LoadingResponse.Failure -> _error.value = result.error
            else -> {
                Log.i("WTF", "какая то непонятная хрень")
            }
        }
    }

    private fun saveData(list: List<UICurrency>) {
        viewModelScope.launch {
            saveCurrenciesUseCase.saveData(list)
        }
    }
}