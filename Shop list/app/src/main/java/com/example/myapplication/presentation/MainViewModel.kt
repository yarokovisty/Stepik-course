package com.example.myapplication.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.repository.ShopListRepositoryImpl
import com.example.myapplication.domain.usecase.DeleteShopItemUseCase
import com.example.myapplication.domain.usecase.EditShopItemUseCase
import com.example.myapplication.domain.usecase.GetShopListUseCase
import com.example.myapplication.domain.entity.ShopItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getShopListUseCase: GetShopListUseCase,
    private val deleteShopListUseCase: DeleteShopItemUseCase,
    private val editShopItemUseCase: EditShopItemUseCase
) : ViewModel() {

    val shopList = getShopListUseCase()

    fun deleteShopItem(shopItem: ShopItem) {
        viewModelScope.launch {
            deleteShopListUseCase(shopItem)
        }

    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)

        viewModelScope.launch {
            editShopItemUseCase(newItem)
        }

    }
}