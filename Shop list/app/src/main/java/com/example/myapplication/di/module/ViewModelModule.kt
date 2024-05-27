package com.example.myapplication.di.module

import androidx.lifecycle.ViewModel
import com.example.myapplication.di.key.ViewModelKey
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.ShopItemViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShopItemViewModel::class)
    fun bindShopItemViewModel(viewModel: ShopItemViewModel): ViewModel

}