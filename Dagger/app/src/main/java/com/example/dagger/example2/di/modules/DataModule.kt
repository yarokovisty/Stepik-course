package com.example.dagger.example2.di.modules

import com.example.dagger.example2.data.datasource.ExampleLocalDataSource
import com.example.dagger.example2.data.datasource.ExampleLocalDataSourceImpl
import com.example.dagger.example2.data.datasource.ExampleRemoteDataSource
import com.example.dagger.example2.data.datasource.ExampleRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindLocalDataSource(impl: ExampleLocalDataSourceImpl): ExampleLocalDataSource

    @Binds
    fun bindRemoteDataSource(impl: ExampleRemoteDataSourceImpl): ExampleRemoteDataSource
}