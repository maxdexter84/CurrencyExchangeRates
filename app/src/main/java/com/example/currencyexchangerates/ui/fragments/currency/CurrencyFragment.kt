package com.example.currencyexchangerates.ui.fragments.currency

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyexchangerates.R
import com.example.currencyexchangerates.databinding.FragmentCurrencyListBinding
import com.example.currencyexchangerates.ui.adapters.currencyadapter.CurrencyAdapter
import com.example.currencyexchangerates.ui.model.UIItemCurrency
import com.example.currencyexchangerates.ui.utils.Sort
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class CurrencyFragment : Fragment() {


    private val currencyViewModel: CurrencyViewModel by lazy {
        ViewModelProvider(this)[CurrencyViewModel::class.java]
    }
    private lateinit var currencyAdapter: CurrencyAdapter

    private var _binding: FragmentCurrencyListBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCurrencyListBinding.inflate(layoutInflater)
        initSwipeRefresh()
        initRecycler()
        errorsObserver()

        binding.ibf.setOnClickListener {
            showPopUp(binding.ibf)
        }
        loadingStateObserver()
        currentCurrencyListObserver()
        searchListObserver()
        spinnerItemSelected()
        return binding.root
    }

    private fun loadingStateObserver() {
        currencyViewModel.loadingState.onEach {
            binding.swipeRefresh.isRefreshing = it
        }.launchIn(lifecycleScope)
    }

    private fun currentCurrencyListObserver() {
        currencyViewModel.currentList.onEach {
            changeAdapterData(it)
        }.launchIn(lifecycleScope)
    }

    private fun searchListObserver() {
        currencyViewModel.searchViewList.onEach { list ->
            val spinnerAdapter =
                ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, list)
            initSpinner(spinnerAdapter)
        }.launchIn(lifecycleScope)
    }

    private fun spinnerItemSelected() {
        binding.spinnerMenu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                currencyViewModel.putPreferencesCurrentCurrency(p2)
                initSpinner(null)
                currencyViewModel.loadData()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                //
            }
        }
    }

    private fun initSpinner(spinnerAdapter: ArrayAdapter<String>?) {
        spinnerAdapter?.let {
            binding.spinnerMenu.adapter = spinnerAdapter
        }
        binding.spinnerMenu.apply {
            val prompt = currencyViewModel.getPreferencesCurrentCurrency()
            val selection = currencyViewModel.searchViewList.value.indexOf(prompt)
            setPrompt(prompt)
            setSelection(selection)
        }
    }

    private fun errorsObserver() {
        currencyViewModel.error.onEach {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG)
                .setAction(getString(R.string.retry)) {
                    currencyViewModel.loadData()
                }.show()
        }.launchIn(lifecycleScope)
    }

    private fun showPopUp(view: View) {
        val popup = PopupMenu(requireContext(), view)
        popup.inflate(R.menu.sorted_menu)
        popup.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.sort_name_high -> {
                    currencyViewModel.saveSortedType(Sort.NAME_HIGH.type)
                    true
                }
                R.id.sort_name_low -> {
                    currencyViewModel.saveSortedType(Sort.NAME_LOW.type)
                    true
                }
                R.id.sort_value_high -> {
                    currencyViewModel.saveSortedType(Sort.VALUE_HIGH.type)
                    true
                }
                R.id.sort_value_low -> {
                    currencyViewModel.saveSortedType(Sort.VALUE_LOW.type)
                    true
                }
                else -> {
                    false
                }
            }
        }
        popup.show()
    }

    private fun changeAdapterData(list: List<UIItemCurrency>?) {
        currencyAdapter.submitList(list)
    }

    @SuppressLint("ResourceAsColor")
    private fun initSwipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener {
            currencyViewModel.loadData()
            binding.swipeRefresh.isRefreshing = false
        }
    }

    private fun initRecycler() {
        currencyAdapter =
            CurrencyAdapter { item ->
                currencyViewModel.saveBookmark(item)
            }

        binding.rvCurrencyList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCurrencyList.adapter = currencyAdapter
        currencyViewModel.currency.onEach {
            it?.let {
                currencyAdapter.submitList(it.listItem)
                binding.collapsingToolbar.title = it.base
            }

        }.launchIn(lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}