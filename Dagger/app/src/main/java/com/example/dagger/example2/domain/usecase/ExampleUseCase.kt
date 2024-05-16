package com.example.dagger.example2.domain.usecase

import com.example.dagger.example2.domain.repository.ExampleRepository
import javax.inject.Inject

class ExampleUseCase @Inject constructor(
    private val repository: ExampleRepository
) {

    operator fun invoke() {
        repository.method()
    }
}