package com.example.dagger.example2.presentation

import androidx.lifecycle.ViewModel
import com.example.dagger.example2.domain.usecase.ExampleUseCase
import javax.inject.Inject

class ExampleViewModel @Inject constructor(
    private val useCase: ExampleUseCase
) : ViewModel() {

    fun method() {
        useCase()
    }
}