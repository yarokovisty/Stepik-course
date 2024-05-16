package com.example.crypto.domain.usecase

import com.example.crypto.domain.repository.CoinRepository

class GetCoinInfoListUseCase(private val repository: CoinRepository) {

    operator fun invoke() = repository.getCoinInfoList()
}