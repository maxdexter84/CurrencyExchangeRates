package com.example.currencyexchangerates.ui.fragments.calculator

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.currencyexchangerates.R
import com.example.currencyexchangerates.databinding.FragmentCalculatorDialogBinding


class CalculatorDialogFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentCalculatorDialogBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_calculator_dialog,container, false)

        return binding.root
    }








}