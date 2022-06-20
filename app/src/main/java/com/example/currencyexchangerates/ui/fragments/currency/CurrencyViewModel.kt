package com.example.currencyexchangerates.ui.fragments.currency

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyexchangerates.AppPreferences
import com.example.currencyexchangerates.domain.usecases.GetCurrenciesUseCase
import com.example.currencyexchangerates.domain.usecases.SaveCurrenciesUseCase
import com.example.currencyexchangerates.ui.map.convertToUICurrencyList
import com.example.currencyexchangerates.ui.model.UICurrency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CurrencyViewModel(
    private val getCurrenciesUseCase: GetCurrenciesUseCase,
    private val saveCurrenciesUseCase: SaveCurrenciesUseCase,
    private val prefs: AppPreferences
) : ViewModel() {

    private val _currencyList = MutableStateFlow<UICurrency?>(null)
    val currencyList = _currencyList.asStateFlow()

    private val _error = MutableStateFlow("")
    val error = _error.asStateFlow()

    private val _loadingState = MutableStateFlow(false)
    val loadingState = _error.asStateFlow()


    init {
        startApp()

    }

    fun startApp() {
//        val launch = prefs.launches
//        if (launch >= 1) {
//            getLocalData()
//        } else loadData("RUB")
        loadData("RUB")
    }

    private fun getLocalData() {
//        viewModelScope.launch {
//            getCurrenciesUseCase.getLocalData().collect {
//                _currencyList.value = it
//            }
//        }
    }

    fun loadData(symbol: String) {
        _loadingState.value = true
        viewModelScope.launch(Dispatchers.IO) {
            getCurrenciesUseCase.getRemoteData(symbol)
                .map {
                    it.convertToUICurrencyList()
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