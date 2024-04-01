package com.example.myapplication.presentation

import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemShopDisabledBinding
import com.example.myapplication.databinding.ItemShopEnabledBinding
import com.example.myapplication.domain.ShopItem

class ShopItemHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {


    fun bind(shopItem: ShopItem) {
        when (binding) {
            is ItemShopEnabledBinding -> {
                binding.apply {
                    tvName.text = shopItem.name
                    tvCount.text = shopItem.count.toString()
                }
            }
            is ItemShopDisabledBinding -> {
                binding.apply {
                    tvName.text = shopItem.name
                    tvCount.text = shopItem.count.toString()
                }
            }

        }


    }
}