package com.example.currencyexchangerates.ui.fragments.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {


    private val _calculateRes = MutableLiveData<String>("")
            val calculateRes: LiveData<String>
            get() = _calculateRes

    fun calculate(nominal: String = "", rate: String = "", sum: String = ""){
        val unit = nominal.toDoubleOrNull()
        val exchangeRate = rate.toDoubleOrNull()
        val sumToConvert = sum.toDoubleOrNull()
        var result = ""
        if ((unit != null && unit > 0) && (exchangeRate != null && exchangeRate > 0) && (sumToConvert != null && sumToConvert > 0))
            _calculateRes.value = "${sumToConvert * unit / exchangeRate}"

    }
}