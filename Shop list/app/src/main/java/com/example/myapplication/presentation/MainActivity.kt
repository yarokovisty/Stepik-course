package com.example.myapplication.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ShopListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecycleView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            adapter.submitList(it)
        }
    }

    private fun setupRecycleView() {
        adapter = ShopListAdapter()
        with(binding.rvShopList) {
            adapter = this@MainActivity.adapter
            recycledViewPool.setMaxRecycledViews(
                ShopListAdapter.VIEW_TYPE_ENABLED,
                ShopListAdapter.MAX_POOL_SIZE
            )
            recycledViewPool.setMaxRecycledViews(
                ShopListAdapter.VIEW_TYPE_DISABLED,
                ShopListAdapter.MAX_POOL_SIZE
            )

        }

        setupClickListener()
        setupLongClickListener()
        setupSwipeListener()
    }

    private fun setupSwipeListener() {
        val callback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = adapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteShopItem(item)
            }

        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.rvShopList)
    }

    private fun setupLongClickListener() {
        adapter.onShopItemLongClickListener = { shopItem ->
            viewModel.changeEnableState(shopItem)
        }
    }

    private fun setupClickListener() {
        adapter.onShopItemClickListener = { shopItem ->
            Log.i("MyLog", shopItem.toString())
        }
    }


}