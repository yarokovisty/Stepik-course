package com.example.myapplication.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.ShopListRepositoryImpl
import com.example.myapplication.domain.DeleteShopItemUseCase
import com.example.myapplication.domain.EditShopItemUseCase
import com.example.myapplication.domain.GetShopListUseCase
import com.example.myapplication.domain.ShopItem
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ShopListRepositoryImpl(application)

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopListUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        viewModelScope.launch {
            deleteShopListUseCase.deleteShopItem(shopItem)
        }

    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)

        viewModelScope.launch {
            editShopItemUseCase.editShopItem(newItem)
        }

    }
}