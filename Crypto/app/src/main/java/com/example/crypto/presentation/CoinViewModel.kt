package com.example.crypto.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.crypto.data.repository.CoinRepositoryImpl
import com.example.crypto.domain.usecase.GetCoinInfoListUseCase
import com.example.crypto.domain.usecase.GetCoinInfoUseCase
import com.example.crypto.domain.usecase.LoadDataUseCase
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)

    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        loadDataUseCase()
    }
}