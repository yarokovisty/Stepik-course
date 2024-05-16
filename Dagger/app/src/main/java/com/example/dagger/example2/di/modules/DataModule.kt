package com.example.dagger.example2.di.modules

import com.example.dagger.example2.data.datasource.ExampleLocalDataSource
import com.example.dagger.example2.data.datasource.ExampleLocalDataSourceImpl
import com.example.dagger.example2.data.datasource.ExampleRemoteDataSource
import com.example.dagger.example2.data.datasource.ExampleRemoteDataSourceImpl
import com.example.dagger.example2.di.scopes.AppScope
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @AppScope
    @Binds
    fun bindLocalDataSource(impl: ExampleLocalDataSourceImpl): ExampleLocalDataSource

    @AppScope
    @Binds
    fun bindRemoteDataSource(impl: ExampleRemoteDataSourceImpl): ExampleRemoteDataSource
}