package com.example.dagger.example2.data.repository

import com.example.dagger.example2.data.datasource.ExampleLocalDataSource
import com.example.dagger.example2.data.datasource.ExampleRemoteDataSource
import com.example.dagger.example2.data.mapper.ExampleMapper
import com.example.dagger.example2.domain.repository.ExampleRepository
import javax.inject.Inject

class ExampleRepositoryImpl @Inject constructor(
    private val localDataSource: ExampleLocalDataSource,
    private val remoteDataSource: ExampleRemoteDataSource,
    private val mapper: ExampleMapper
) : ExampleRepository {

    override fun method() {
        mapper.map()
        localDataSource.method()
        remoteDataSource.method()
    }
}