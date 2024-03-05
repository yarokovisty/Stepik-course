package com.example.myapplication.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemShopEnabledBinding
import com.example.myapplication.domain.ShopItem

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemHolder>() {
    var shopList = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ShopItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemShopEnabledBinding.bind(view)

        fun bind(shopItem: ShopItem) {
            binding.apply {
                tvName.text = shopItem.name
                tvCount.text = shopItem.count.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_shop_enabled,
                parent,
                false
            )
        return ShopItemHolder(view)
    }

    override fun getItemCount(): Int {
        return shopList.size
    }

    override fun onBindViewHolder(holder: ShopItemHolder, position: Int) {
        holder.bind(shopList[position])
    }


}