package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.entity.ShopItem
import com.example.myapplication.domain.repository.ShopListRepository
import javax.inject.Inject

class EditShopItemUseCase @Inject constructor(
    private val shopListRepository: ShopListRepository
) {

    suspend operator fun invoke(shopItem: ShopItem) {
        shopListRepository.editShopItem(shopItem)
    }
}