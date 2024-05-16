package com.example.dagger.example2.di.modules

import androidx.lifecycle.ViewModel
import com.example.dagger.example2.di.ViewModelKey
import com.example.dagger.example2.presentation.ExampleViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(ExampleViewModel::class)
    @Binds
    fun bindExampleViewModel(impl: ExampleViewModel): ViewModel

}