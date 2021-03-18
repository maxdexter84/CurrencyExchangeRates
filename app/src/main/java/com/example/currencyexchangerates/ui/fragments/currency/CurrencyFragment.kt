package com.example.currencyexchangerates.ui.fragments.currency

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyexchangerates.R
import com.example.currencyexchangerates.data.locale.AppDatabase
import com.example.currencyexchangerates.data.locale.ILocalDataSource
import com.example.currencyexchangerates.data.locale.LocalDataSourceImpl
import com.example.currencyexchangerates.data.remote.CurrencyApi
import com.example.currencyexchangerates.data.remote.IRemoteDataSource
import com.example.currencyexchangerates.data.remote.RemoteDataSourceImpl
import com.example.currencyexchangerates.databinding.FragmentCurrencyListBinding
import com.example.currencyexchangerates.repository.IRepository
import com.example.currencyexchangerates.repository.RepositoryImpl
import com.example.currencyexchangerates.ui.adapters.CurrencyAdapter

class CurrencyFragment : Fragment() {

    private val repository: IRepository by lazy {
        val remoteSource: IRemoteDataSource = RemoteDataSourceImpl(CurrencyApi.currencyService)
        val localSource: ILocalDataSource = LocalDataSourceImpl(
            AppDatabase.invoke(requireContext()).getBookmarkDao(),
            AppDatabase.invoke(requireContext()).getCurrencyDao())
        RepositoryImpl(remoteSource,localSource)
    }

    private val currencyViewModel: CurrencyViewModel by lazy {
        ViewModelProvider(this, CurrencyFragmentViewModelFactory(repository)).get(CurrencyViewModel::class.java)
    }

    private val currencyAdapter: CurrencyAdapter by lazy {
        CurrencyAdapter()
    }

    private lateinit var binding: FragmentCurrencyListBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_currency_list, container, false)

        initSwipeRefresh()
        initRecycler()
        return binding.root
    }
    @SuppressLint("ResourceAsColor")
    private fun initSwipeRefresh() {
        binding.swipeRefresh.setProgressBackgroundColorSchemeColor(R.color.purple_200)
        binding.swipeRefresh.setOnRefreshListener {
            currencyViewModel.getData()
            binding.swipeRefresh.isRefreshing = false
        }
    }

    private fun initRecycler() {
        binding.rvCurrencyList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCurrencyList.adapter = currencyAdapter
        currencyViewModel.currencyList.observe(viewLifecycleOwner, {
            currencyAdapter.submitList(it)
        })
    }
}