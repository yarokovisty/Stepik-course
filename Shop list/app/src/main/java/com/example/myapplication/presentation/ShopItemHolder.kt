package com.example.myapplication.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemShopEnabledBinding
import com.example.myapplication.domain.ShopItem

class ShopItemHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemShopEnabledBinding.bind(view)

    fun bind(shopItem: ShopItem) {
        binding.apply {
            tvName.text = shopItem.name
            tvCount.text = shopItem.count.toString()
        }

    }
}