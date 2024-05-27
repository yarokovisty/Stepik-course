package com.example.myapplication.domain.usecase

import androidx.lifecycle.LiveData
import com.example.myapplication.domain.entity.ShopItem
import com.example.myapplication.domain.repository.ShopListRepository
import javax.inject.Inject

class GetShopListUseCase @Inject constructor(
    private val shopListRepository: ShopListRepository
) {
    operator fun invoke(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}