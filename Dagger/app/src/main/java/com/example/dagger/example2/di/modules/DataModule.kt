package com.example.dagger.example2.di.modules

import com.example.dagger.example2.data.datasource.ExampleLocalDataSource
import com.example.dagger.example2.data.datasource.ExampleLocalDataSourceImpl
import com.example.dagger.example2.data.datasource.ExampleRemoteDataSource
import com.example.dagger.example2.data.datasource.ExampleRemoteDataSourceImpl
import com.example.dagger.example2.data.datasource.TestRemoteDataSourceImpl
import com.example.dagger.example2.di.annotations.ProdQualifier
import com.example.dagger.example2.di.annotations.TestQualifier
import com.example.dagger.example2.di.scopes.AppScope
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @AppScope
    @Binds
    fun bindLocalDataSource(impl: ExampleLocalDataSourceImpl): ExampleLocalDataSource

    @ProdQualifier
    @AppScope
    @Binds
    fun bindRemoteDataSource(impl: ExampleRemoteDataSourceImpl): ExampleRemoteDataSource

    @TestQualifier
    @AppScope
    @Binds
    fun bindTestRemoteDataSource(impl: TestRemoteDataSourceImpl): ExampleRemoteDataSource
}