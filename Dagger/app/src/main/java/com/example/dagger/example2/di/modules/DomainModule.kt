package com.example.dagger.example2.di.modules

import com.example.dagger.example2.data.repository.ExampleRepositoryImpl
import com.example.dagger.example2.di.scopes.AppScope
import com.example.dagger.example2.domain.repository.ExampleRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DomainModule {

    @Binds
    fun bindRepository(impl: ExampleRepositoryImpl): ExampleRepository
}