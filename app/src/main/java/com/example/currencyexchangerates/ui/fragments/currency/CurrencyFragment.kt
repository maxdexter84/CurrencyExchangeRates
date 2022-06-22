package com.example.currencyexchangerates.ui.fragments.currency

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyexchangerates.App
import com.example.currencyexchangerates.AppPreferences
import com.example.currencyexchangerates.data.locale.AppDatabase
import com.example.currencyexchangerates.data.locale.LocalRepositoryImpl
import com.example.currencyexchangerates.data.remote.CurrencyApi
import com.example.currencyexchangerates.data.remote.RemoteRepositoryImpl
import com.example.currencyexchangerates.databinding.FragmentCurrencyListBinding
import com.example.currencyexchangerates.domain.repository.LocalRepository
import com.example.currencyexchangerates.domain.repository.RemoteRepository
import com.example.currencyexchangerates.domain.usecaseimpl.BookmarkUseCaseImpl
import com.example.currencyexchangerates.domain.usecaseimpl.GetCurrenciesUseCaseImpl
import com.example.currencyexchangerates.ui.adapters.CurrencyAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


class CurrencyFragment : Fragment() {
    companion object {
        fun newInstance() = CurrencyFragment()
    }

    private val prefs: AppPreferences by lazy {
        App.preferences!!
    }
    lateinit var currencyViewModel: CurrencyViewModel
    private lateinit var currencyAdapter: CurrencyAdapter

    private var _binding: FragmentCurrencyListBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCurrencyListBinding.inflate(layoutInflater)
        initViewModel()
        initSwipeRefresh()
        initRecycler()
        errorsObserver()
        return binding.root
    }

    private fun errorsObserver() {
        currencyViewModel.error.onEach {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).setAction("Retry") {
                currencyViewModel.loadData("RUB")
            }.show()
        }
    }


    private fun initViewModel() {
        val remoteRepository: RemoteRepository = RemoteRepositoryImpl(CurrencyApi.currencyService)
        val localRepository: LocalRepository =
            LocalRepositoryImpl(AppDatabase.invoke(requireContext()).getBookmarkDao())
        val getCurrenciesUseCase = GetCurrenciesUseCaseImpl(remoteRepository, localRepository)
        val bookmarkUseCase = BookmarkUseCaseImpl(localRepository)
        currencyViewModel = ViewModelProvider(
            this,
            CurrencyFragmentViewModelFactory(getCurrenciesUseCase, bookmarkUseCase, prefs)
        ).get(CurrencyViewModel::class.java)
    }


    @SuppressLint("ResourceAsColor")
    private fun initSwipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener {
            currencyViewModel.loadData("RUB")
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
        currencyViewModel.currencyList.onEach {
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