package com.example.crypto.domain.usecase

import com.example.crypto.domain.repository.CoinRepository

class LoadDataUseCase(private val repository: CoinRepository) {

    operator fun invoke() = repository.loadData()
}