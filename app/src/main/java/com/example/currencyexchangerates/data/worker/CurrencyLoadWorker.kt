package com.example.currencyexchangerates.data.worker



import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.currencyexchangerates.data.locale.AppDatabase
import com.example.currencyexchangerates.data.locale.LocalRepositoryImpl
import com.example.currencyexchangerates.data.remote.CurrencyApi
import com.example.currencyexchangerates.data.remote.RemoteRepositoryImpl
import com.example.currencyexchangerates.domain.LoadingResponse
import com.example.currencyexchangerates.domain.repository.LocalRepository
import com.example.currencyexchangerates.domain.repository.RemoteRepository
import com.example.currencyexchangerates.domain.usecaseimpl.GetCurrenciesUseCaseImpl
import com.example.currencyexchangerates.domain.usecaseimpl.SaveCurrenciesUseCaseImpl
import com.example.currencyexchangerates.domain.usecases.SaveCurrenciesUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

private const val TAG_WORKER = "WORKER_MANAGER"

class CurrencyLoadWorker(private val context: Context, private val params: WorkerParameters) :
    Worker(context, params) {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    override fun doWork(): Result {
        return try {
            val remoteRepository: RemoteRepository =
                RemoteRepositoryImpl(CurrencyApi.currencyService)
            val localRepository: LocalRepository =
                LocalRepositoryImpl(AppDatabase.invoke(context).getCurrencyDao())
            val getCurrenciesUseCase = GetCurrenciesUseCaseImpl(remoteRepository, localRepository)

            val saveCurrenciesUseCase = SaveCurrenciesUseCaseImpl(localRepository)
            Log.i(TAG_WORKER, "work is start")
            scope.launch {
                val res = getCurrenciesUseCase.getRemoteData()
                parseResult(res, saveCurrenciesUseCase)
                Log.i(TAG_WORKER, "work is end")
            }

            Result.success()
        } catch (e: Exception) {
            Log.e(TAG_WORKER, e.message.toString())
            Result.failure()
        }

    }

    private suspend fun parseResult(
        result: LoadingResponse,
        saveCurrenciesUseCase: SaveCurrenciesUseCase
    ) {
        when (result) {
            is LoadingResponse.Success -> saveCurrenciesUseCase.saveData(result.data)
            is LoadingResponse.Failure -> {
                Log.e(TAG_WORKER, result.error)
                Result.retry()
            }
            else -> {
                Log.e(TAG_WORKER, result.javaClass.name)
            }
        }
    }
}
