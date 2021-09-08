package com.example.currencyexchangerates.ui.fragments.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.currencyexchangerates.databinding.FragmentCalculatorBinding
import com.example.currencyexchangerates.ui.model.UICurrency


class CalculatorFragment : Fragment() {

    private lateinit var binding: FragmentCalculatorBinding

    private val viewModel: CalculatorViewModel by lazy {
        ViewModelProvider(this).get(CalculatorViewModel::class.java)
    }

    private lateinit var args: UICurrency

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculatorBinding.inflate(layoutInflater)
        arguments.let {
            args = it?.getSerializable(ITEM) as UICurrency
        }
        binding.toolbar2.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
        initCalculate()
        initTV()
        return binding.root
    }

    private fun initTV() {
        binding.tvCurrencyName.text = args.name
        viewModel.calculateRes.observe(viewLifecycleOwner, {
            binding.tvValute.text = it

        })
    }

    private fun initCalculate() {
        val nominal = args.nominal
        val value = args.value
        binding.etRub.doAfterTextChanged {
            viewModel.calculate(nominal, value, it.toString())
        }
    }

    companion object {
        const val ITEM = "UI_ITEM"
        const val TAG = "com.example.currencyexchangerates.ui.fragments.calculator"

        fun newInstance(item: UICurrency) =
            CalculatorFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ITEM, item)
                }
            }
    }


}