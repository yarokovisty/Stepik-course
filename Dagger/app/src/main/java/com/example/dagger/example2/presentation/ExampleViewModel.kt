package com.example.dagger.example2.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.dagger.example2.di.annotations.IdQualifier
import com.example.dagger.example2.di.annotations.NameQualifier
import com.example.dagger.example2.domain.usecase.ExampleUseCase
import javax.inject.Inject
import javax.inject.Named

class ExampleViewModel @Inject constructor(
    private val useCase: ExampleUseCase,
    @IdQualifier private val id: String,
    @NameQualifier private val name: String
) : ViewModel() {

    fun method() {
        useCase()
        Log.i("ExampleViewModel", "$this $id $name")
    }
}