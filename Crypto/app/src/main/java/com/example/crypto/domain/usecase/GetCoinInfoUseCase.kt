package com.example.crypto.domain.usecase

import com.example.crypto.domain.repository.CoinRepository

class GetCoinInfoUseCase(private val repository: CoinRepository) {

    operator fun invoke(fromSymbol: String) = repository.getCoinInfo(fromSymbol)
}