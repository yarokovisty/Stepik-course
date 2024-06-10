package com.example.myapplication.data.contentprovider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.example.myapplication.data.database.ShopListDao
import com.example.myapplication.data.mapper.ShopListMapper
import com.example.myapplication.domain.entity.ShopItem
import javax.inject.Inject
import com.example.myapplication.presentation.ShopApplication

class ShopListProvider : ContentProvider() {

    private val component by lazy {
        (context as ShopApplication).component
    }

    @Inject
    lateinit var shopListDao: ShopListDao

    @Inject
    lateinit var mapper: ShopListMapper

    private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
        addURI("com.example.myapplication", "shop_items", GET_SHOP_ITEMS_QUERY)
        addURI("com.example.myapplication", "shop_items/#", GET_SHOP_ITEM_BY_ID)
    }

    override fun onCreate(): Boolean {
        component.inject(this)
        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        return when(uriMatcher.match(uri)) {
            GET_SHOP_ITEMS_QUERY -> {
                shopListDao.getShopListCursor()
            }
            GET_SHOP_ITEM_BY_ID -> {
                null
            }
            else -> {
                null
            }
        }


    }

    override fun getType(uri: Uri): String? {
        TODO("Not yet implemented")
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        when(uriMatcher.match(uri)) {
            GET_SHOP_ITEMS_QUERY -> {
                if (values == null) return null

                val id = values.getAsInteger(ID_PROVIDER)
                val name = values.getAsString(NAME_PROVIDER)
                val count = values.getAsInteger(COUNT_PROVIDER)
                val enabled = values.getAsBoolean(ENABLED_PROVIDER)

                val shopItem = ShopItem(
                    id = id,
                    name = name,
                    count = count,
                    enabled = enabled
                )

                shopListDao.addShopItemSync(mapper.mapEntityToDbModel(shopItem))
            }
        }

        return null
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        when(uriMatcher.match(uri)) {
            GET_SHOP_ITEMS_QUERY -> {
                val id = selectionArgs?.get(0)?.toInt() ?: -1
                return shopListDao.deleteShopItemSync(id)
            }
        }

        return 0
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        TODO("Not yet implemented")
    }

    companion object {
        private const val GET_SHOP_ITEMS_QUERY = 100
        private const val GET_SHOP_ITEM_BY_ID = 101

        const val ID_PROVIDER = "id"
        const val NAME_PROVIDER = "name"
        const val COUNT_PROVIDER = "count"
        const val ENABLED_PROVIDER = "enabled"
    }
}