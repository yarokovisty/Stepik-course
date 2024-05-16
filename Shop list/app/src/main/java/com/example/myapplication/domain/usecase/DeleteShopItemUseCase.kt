package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.entity.ShopItem
import com.example.myapplication.domain.repository.ShopListRepository

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {
    suspend fun deleteShopItem(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }
}