package com.example.myapplication.di.module

import android.app.Application
import com.example.myapplication.data.database.AppDatabase
import com.example.myapplication.data.database.ShopListDao
import com.example.myapplication.data.repository.ShopListRepositoryImpl
import com.example.myapplication.di.scope.AppScope
import com.example.myapplication.domain.repository.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @AppScope
    @Binds
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object {

        @AppScope
        @Provides
        fun provideShopListDao(
            application: Application
        ): ShopListDao {
            return AppDatabase.getInstance(application).shopListDao()
        }
    }
}